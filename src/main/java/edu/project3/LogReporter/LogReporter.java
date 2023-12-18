package edu.project3.LogReporter;

import edu.project3.LogRecord;
import edu.project3.Utils.AdocUtils;
import edu.project3.Utils.LogStatisticUtils;
import edu.project3.Utils.MarkdownUtils;
import edu.project3.Utils.StatusCode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogReporter implements Reporter {
    private static final String MARKDOWN = "markdown";
    private static final String ADOC = "adoc";
    private static final String COUNT_RESPONSE = "Количество запросов";
    private static final String GENERAL_INFORMATION = "Общая информпция";
    private static final String COUNT = "Количество";
    private static final String REQUESTED_RESOURCES = "Запрашиваемые ресурсы";
    private static final String RESPONSE_CODES = "Коды ответа";
    private static final String BUSY_DAYS = "Загруженность дней";
    private static final String REQUEST_TYPES = "Типы запросов";
    private static final String COUNT_BYTES_UPLOAD_FOR_EACH_DAY = "Количество байт выгруженных за каждый день";
    private static final String DAY = "День";
    private static final String NUMBER_FORMAT = "###,###.##";
    private final List<LogRecord> logRecordList;
    private final String format;

    public LogReporter(List<LogRecord> logRecordList, String format) {
        this.logRecordList = logRecordList;
        this.format = format;
    }

    public LogReporter(List<LogRecord> logRecordList) {
        this(logRecordList, MARKDOWN);
    }

    @Override
    public String generalInformation() {
        List<List<String>> table = new ArrayList<>(
            List.of(
                new ArrayList<>(List.of("Метрика", "Значение")),
                new ArrayList<>(List.of("Файл(-ы)", "`access.log`")),
                new ArrayList<>(List.of("Начальная дата", LogStatisticUtils.startingDate(logRecordList).toString())),
                new ArrayList<>(List.of("Конечная дата", LogStatisticUtils.endDate(logRecordList).toString())),
                new ArrayList<>(List.of(COUNT_RESPONSE, String.valueOf(LogStatisticUtils.countRequest(logRecordList)))),
                new ArrayList<>(List.of(
                    "Средний размер ответа",
                    formatNumber(LogStatisticUtils.averageResponseSize(logRecordList)) + "b"

                ))
            )
        );
        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(GENERAL_INFORMATION, table)
            : AdocUtils.createTable(GENERAL_INFORMATION, table);
    }

    @Override
    public String requestedResources() {
        Map<Object, Long> map = LogStatisticUtils.frequencyDictionary(logRecordList, LogRecord::documentName);
        List<Map.Entry<Object, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<List<String>> table = new ArrayList<>(
            List.of(new ArrayList<>(List.of("Ресурс", COUNT)))
        );
        for (Map.Entry<Object, Long> objectLongEntry : list) {
            table.add(new ArrayList<>(List.of(
                objectLongEntry.getKey().toString(),
                formatNumber(objectLongEntry.getValue())
            )));
        }

        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(REQUESTED_RESOURCES, table)
            : AdocUtils.createTable(REQUESTED_RESOURCES, table);
    }

    @Override
    public String responseCodes() {
        Map<Object, Long> map = LogStatisticUtils.frequencyDictionary(logRecordList, LogRecord::httpResponseCode);
        List<Map.Entry<Object, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<List<String>> table = new ArrayList<>(
            List.of(new ArrayList<>(List.of("Код", "Имя", COUNT)))
        );

        for (Map.Entry<Object, Long> objectLongEntry : list) {
            table.add(new ArrayList<>(List.of(
                objectLongEntry.getKey().toString(),
                StatusCode.STATUS_CODE.get(objectLongEntry.getKey()),
                formatNumber(objectLongEntry.getValue())
            )));
        }

        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(RESPONSE_CODES, table)
            : AdocUtils.createTable(RESPONSE_CODES, table);
    }

    @Override
    public String busiestDays() {
        Map<Object, Long> map = LogStatisticUtils.frequencyDictionary(
            logRecordList,
            LogRecord::convertOffsetDateTimeToLocalDate
        );

        List<Map.Entry<Object, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<List<String>> table = new ArrayList<>(
            List.of(new ArrayList<>(List.of(DAY, COUNT_RESPONSE)))
        );

        for (Map.Entry<Object, Long> objectLongEntry : list) {
            table.add(new ArrayList<>(List.of(
                objectLongEntry.getKey().toString(),
                formatNumber(objectLongEntry.getValue())
            )));
        }

        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(BUSY_DAYS, table)
            : AdocUtils.createTable(BUSY_DAYS, table);
    }

    @Override
    public String requestTypes() {
        Map<Object, Long> map = LogStatisticUtils.frequencyDictionary(logRecordList, LogRecord::requestType);
        List<Map.Entry<Object, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<List<String>> table = new ArrayList<>(
            List.of(new ArrayList<>(List.of("Тип запроса", COUNT_RESPONSE)))
        );

        for (Map.Entry<Object, Long> objectLongEntry : list) {
            table.add(new ArrayList<>(List.of(
                objectLongEntry.getKey().toString(),
                formatNumber(objectLongEntry.getValue())
            )));
        }

        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(REQUEST_TYPES, table)
            : AdocUtils.createTable(REQUEST_TYPES, table);
    }

    @Override
    public String countUploadsBytesForEachDay() {
        Map<Object, Long> map = logRecordList.stream()
            .collect(Collectors.toMap(
                LogRecord::convertOffsetDateTimeToLocalDate,
                LogRecord::responseSizeBytes,
                Long::sum
            ));

        List<Map.Entry<Object, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<List<String>> table = new ArrayList<>(
            List.of(new ArrayList<>(List.of(DAY, "Количество выгруженных байт")))
        );

        for (Map.Entry<Object, Long> objectLongEntry : list) {
            table.add(new ArrayList<>(List.of(
                objectLongEntry.getKey().toString(),
                formatNumber(objectLongEntry.getValue())
            )));
        }

        return (!format.equals(ADOC)) ? MarkdownUtils.createTable(COUNT_BYTES_UPLOAD_FOR_EACH_DAY, table)
            : AdocUtils.createTable(COUNT_BYTES_UPLOAD_FOR_EACH_DAY, table);
    }

    private String formatNumber(double number) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('_');

        return new DecimalFormat(NUMBER_FORMAT, symbols).format(number).replace(",", ".");
    }

    private String formatNumber(long number) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('_');

        return new DecimalFormat(NUMBER_FORMAT, symbols).format(number);
    }
}
