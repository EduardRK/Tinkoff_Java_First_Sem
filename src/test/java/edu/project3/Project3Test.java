package edu.project3;

import edu.project3.LogReader.LogFileReader;
import edu.project3.LogReader.LogReader;
import edu.project3.LogReader.LogURIReader;
import edu.project3.LogReporter.LogReporter;
import edu.project3.LogReporter.Reporter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Project3Test {
    private static final String GENERAL_INFORMATION_MARKDOWN = """
        #### Общая информпция

        |        Метрика        |      Значение|
        |:---------------------:|-------------:|
        |       Файл(-ы)        |  `access.log`|
        |    Начальная дата     |    2015-05-17|
        |     Конечная дата     |    2015-06-04|
        |  Количество запросов  |         51462|
        | Средний размер ответа |   659_509.51b|
        """;
    private static final String REQUESTED_RESOURCES_MARKDOWN = """
        #### Запрашиваемые ресурсы

        |        Ресурс        |  Количество|
        |:--------------------:|-----------:|
        | /downloads/product_1 |      30_285|
        | /downloads/product_2 |      21_104|
        | /downloads/product_3 |          73|
        """;
    private static final String REQUEST_TYPES_MARKDOWN = """
        #### Типы запросов

        | Тип запроса |  Количество запросов|
        |:-----------:|--------------------:|
        |     GET     |               51_379|
        |    HEAD     |                   83|
        """;
    private static final String RESPONSE_CODES_MARKDOWN = """
        #### Коды ответа

        | Код |          Имя          |  Количество|
        |:---:|:---------------------:|-----------:|
        | 404 |       Not Found       |      33_876|
        | 304 |     Not Modified      |      13_330|
        | 200 |          OK           |       4_028|
        | 206 |    Partial Content    |         186|
        | 403 |       Forbidden       |          38|
        | 416 | Range Not Satisfiable |           4|
        """;
    private static final String COUNT_UPLOADS_BYTES_FOR_EACH_DAY_MARKDOWN = """
        #### Количество байт выгруженных за каждый день

        |    День    |  Количество выгруженных байт|
        |:----------:|----------------------------:|
        | 2015-05-27 |                2_960_334_238|
        | 2015-05-20 |                2_708_334_863|
        | 2015-05-29 |                2_360_377_268|
        | 2015-05-24 |                2_344_127_748|
        | 2015-05-19 |                2_215_968_215|
        | 2015-05-28 |                2_171_474_479|
        | 2015-06-02 |                1_966_627_420|
        | 2015-05-22 |                1_956_173_891|
        | 2015-05-21 |                1_843_775_769|
        | 2015-05-23 |                1_820_745_298|
        | 2015-05-30 |                1_732_777_182|
        | 2015-05-25 |                1_667_324_342|
        | 2015-05-31 |                1_645_156_383|
        | 2015-06-03 |                1_617_248_986|
        | 2015-05-18 |                1_606_641_529|
        | 2015-06-01 |                1_468_603_386|
        | 2015-05-26 |                1_006_174_148|
        | 2015-06-04 |                  715_465_049|
        | 2015-05-17 |                  132_348_436|
        """;
    private static final String BUSIEST_DAYS_MARKDOWN = """
        #### Загруженность дней

        |    День    |  Количество запросов|
        |:----------:|--------------------:|
        | 2015-05-23 |                2_892|
        | 2015-05-27 |                2_887|
        | 2015-05-21 |                2_881|
        | 2015-05-26 |                2_879|
        | 2015-05-22 |                2_879|
        | 2015-05-30 |                2_876|
        | 2015-06-02 |                2_864|
        | 2015-05-31 |                2_863|
        | 2015-05-18 |                2_855|
        | 2015-05-24 |                2_853|
        | 2015-05-28 |                2_852|
        | 2015-05-20 |                2_851|
        | 2015-05-25 |                2_839|
        | 2015-06-01 |                2_837|
        | 2015-05-29 |                2_836|
        | 2015-05-19 |                2_831|
        | 2015-06-03 |                2_825|
        | 2015-05-17 |                1_966|
        | 2015-06-04 |                  896|
                        """;

    private static final String GENERAL_INFORMATION_ADOC = """
        ==== Общая информпция
        [format="csv", options="header"]
        |===
        Метрика,Значение,
        Файл(-ы),`access.log`,
        Начальная дата,2015-05-17,
        Конечная дата,2015-06-04,
        Количество запросов,51462,
        Средний размер ответа,659_509.51b,
        |===

        """;
    private static final String REQUESTED_RESOURCES_ADOC = """
        ==== Запрашиваемые ресурсы
        [format="csv", options="header"]
        |===
        Ресурс,Количество,
        /downloads/product_1,30_285,
        /downloads/product_2,21_104,
        /downloads/product_3,73,
        |===

        """;

    private static final String REQUEST_TYPES_ADOC = """
        ==== Типы запросов
        [format="csv", options="header"]
        |===
        Тип запроса,Количество запросов,
        GET,51_379,
        HEAD,83,
        |===

        """;

    private static final String RESPONSE_CODES_ADOC = """
        ==== Коды ответа
        [format="csv", options="header"]
        |===
        Код,Имя,Количество,
        404,Not Found,33_876,
        304,Not Modified,13_330,
        200,OK,4_028,
        206,Partial Content,186,
        403,Forbidden,38,
        416,Range Not Satisfiable,4,
        |===

        """;
    private static final String COUNT_UPLOADS_BYTES_FOR_EACH_DAY_ADOC = """
        ==== Количество байт выгруженных за каждый день
        [format="csv", options="header"]
        |===
        День,Количество выгруженных байт,
        2015-05-27,2_960_334_238,
        2015-05-20,2_708_334_863,
        2015-05-29,2_360_377_268,
        2015-05-24,2_344_127_748,
        2015-05-19,2_215_968_215,
        2015-05-28,2_171_474_479,
        2015-06-02,1_966_627_420,
        2015-05-22,1_956_173_891,
        2015-05-21,1_843_775_769,
        2015-05-23,1_820_745_298,
        2015-05-30,1_732_777_182,
        2015-05-25,1_667_324_342,
        2015-05-31,1_645_156_383,
        2015-06-03,1_617_248_986,
        2015-05-18,1_606_641_529,
        2015-06-01,1_468_603_386,
        2015-05-26,1_006_174_148,
        2015-06-04,715_465_049,
        2015-05-17,132_348_436,
        |===

        """;

    private static final String BUSIEST_DAYS_ADOC = """
        ==== Загруженность дней
        [format="csv", options="header"]
        |===
        День,Количество запросов,
        2015-05-23,2_892,
        2015-05-27,2_887,
        2015-05-21,2_881,
        2015-05-26,2_879,
        2015-05-22,2_879,
        2015-05-30,2_876,
        2015-06-02,2_864,
        2015-05-31,2_863,
        2015-05-18,2_855,
        2015-05-24,2_853,
        2015-05-28,2_852,
        2015-05-20,2_851,
        2015-05-25,2_839,
        2015-06-01,2_837,
        2015-05-29,2_836,
        2015-05-19,2_831,
        2015-06-03,2_825,
        2015-05-17,1_966,
        2015-06-04,896,
        |===

        """;

    private static final String GENERAL_INFORMATION_MARKDOWN_RANGE = """
        #### Общая информпция

        |        Метрика        |      Значение|
        |:---------------------:|-------------:|
        |       Файл(-ы)        |  `access.log`|
        |    Начальная дата     |    2015-05-23|
        |     Конечная дата     |    2015-05-31|
        |  Количество запросов  |         25777|
        | Средний размер ответа |   686_988.05b|
        """;

    private static final String REQUEST_TYPES_MARKDOWN_RANGE = """
        #### Типы запросов

        | Тип запроса |  Количество запросов|
        |:-----------:|--------------------:|
        |     GET     |               25_742|
        |    HEAD     |                   35|
        """;

    private static final String RESPONSE_CODES_MARKDOWN_RANGE = """
        #### Коды ответа

        | Код |          Имя          |  Количество|
        |:---:|:---------------------:|-----------:|
        | 404 |       Not Found       |      16_828|
        | 304 |     Not Modified      |       6_770|
        | 200 |          OK           |       2_076|
        | 206 |    Partial Content    |          82|
        | 403 |       Forbidden       |          17|
        | 416 | Range Not Satisfiable |           4|
        """;

    private static final String REQUESTED_RESOURCES_MARKDOWN_RANGE = """
        #### Запрашиваемые ресурсы

        |        Ресурс        |  Количество|
        |:--------------------:|-----------:|
        | /downloads/product_1 |      15_067|
        | /downloads/product_2 |      10_672|
        | /downloads/product_3 |          38|
        """;

    private static final String BUSIEST_DAYS_MARKDOWN_RANGE = """
        #### Загруженность дней

        |    День    |  Количество запросов|
        |:----------:|--------------------:|
        | 2015-05-23 |                2_892|
        | 2015-05-27 |                2_887|
        | 2015-05-26 |                2_879|
        | 2015-05-30 |                2_876|
        | 2015-05-31 |                2_863|
        | 2015-05-24 |                2_853|
        | 2015-05-28 |                2_852|
        | 2015-05-25 |                2_839|
        | 2015-05-29 |                2_836|
        """;

    @Nested
    @DisplayName("Logs from file")
    class LogsFromFile {
        private static final Path PATH = Path.of("src/main/resources/Project3Logs/logs.txt");
        private static final LogReader LOG_READER = new LogFileReader(PATH);

        @Test
        @DisplayName("All logs (markdown)")
        public void allLogsMarkdown() {
            List<LogRecord> logRecordList = LOG_READER.readLogs();
            Reporter reporter = new LogReporter(logRecordList);

            Assertions.assertEquals(GENERAL_INFORMATION_MARKDOWN, reporter.generalInformation());
            Assertions.assertEquals(REQUESTED_RESOURCES_MARKDOWN, reporter.requestedResources());
            Assertions.assertEquals(REQUEST_TYPES_MARKDOWN, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_MARKDOWN, reporter.responseCodes());
            Assertions.assertEquals(COUNT_UPLOADS_BYTES_FOR_EACH_DAY_MARKDOWN, reporter.countUploadsBytesForEachDay());
            Assertions.assertEquals(BUSIEST_DAYS_MARKDOWN, reporter.busiestDays());
        }

        @Test
        @DisplayName("All logs (adoc)")
        public void allLogsAdoc() {
            List<LogRecord> logRecordList = LOG_READER.readLogs();
            Reporter reporter = new LogReporter(logRecordList, "adoc");

            Assertions.assertEquals(GENERAL_INFORMATION_ADOC, reporter.generalInformation());
            Assertions.assertEquals(REQUESTED_RESOURCES_ADOC, reporter.requestedResources());
            Assertions.assertEquals(REQUEST_TYPES_ADOC, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_ADOC, reporter.responseCodes());
            Assertions.assertEquals(COUNT_UPLOADS_BYTES_FOR_EACH_DAY_ADOC, reporter.countUploadsBytesForEachDay());
            Assertions.assertEquals(BUSIEST_DAYS_ADOC, reporter.busiestDays());
        }

        @Test
        @DisplayName("Logs from range")
        public void logsFromRangeMarkdown() {
            LocalDate fromDate = LocalDate.parse("2015-05-23", DateTimeFormatter.ISO_DATE);
            LocalDate toDate = LocalDate.parse("2015-06-01", DateTimeFormatter.ISO_DATE);

            List<LogRecord> logRecordList = LOG_READER.readLogs(fromDate, toDate);
            Reporter reporter = new LogReporter(logRecordList);

            Assertions.assertEquals(GENERAL_INFORMATION_MARKDOWN_RANGE, reporter.generalInformation());
            Assertions.assertEquals(REQUEST_TYPES_MARKDOWN_RANGE, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_MARKDOWN_RANGE, reporter.responseCodes());
            Assertions.assertEquals(REQUESTED_RESOURCES_MARKDOWN_RANGE, reporter.requestedResources());
            Assertions.assertEquals(BUSIEST_DAYS_MARKDOWN_RANGE, reporter.busiestDays());

        }
    }

    @Nested
    @DisplayName("Logs from uri")
    class LogsFromURI {
        private static final String URI =
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";
        private static final LogReader LOG_READER = new LogURIReader(URI);

        @Test
        @DisplayName("All logs (markdown)")
        public void allLogsMarkdown() {
            List<LogRecord> logRecordList = LOG_READER.readLogs();
            Reporter reporter = new LogReporter(logRecordList);

            Assertions.assertEquals(GENERAL_INFORMATION_MARKDOWN, reporter.generalInformation());
            Assertions.assertEquals(REQUESTED_RESOURCES_MARKDOWN, reporter.requestedResources());
            Assertions.assertEquals(REQUEST_TYPES_MARKDOWN, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_MARKDOWN, reporter.responseCodes());
            Assertions.assertEquals(COUNT_UPLOADS_BYTES_FOR_EACH_DAY_MARKDOWN, reporter.countUploadsBytesForEachDay());
            Assertions.assertEquals(BUSIEST_DAYS_MARKDOWN, reporter.busiestDays());
        }

        @Test
        @DisplayName("All logs (adoc)")
        public void allLogsAdoc() {
            List<LogRecord> logRecordList = LOG_READER.readLogs();
            Reporter reporter = new LogReporter(logRecordList, "adoc");

            Assertions.assertEquals(GENERAL_INFORMATION_ADOC, reporter.generalInformation());
            Assertions.assertEquals(REQUESTED_RESOURCES_ADOC, reporter.requestedResources());
            Assertions.assertEquals(REQUEST_TYPES_ADOC, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_ADOC, reporter.responseCodes());
            Assertions.assertEquals(COUNT_UPLOADS_BYTES_FOR_EACH_DAY_ADOC, reporter.countUploadsBytesForEachDay());
            Assertions.assertEquals(BUSIEST_DAYS_ADOC, reporter.busiestDays());
        }

        @Test
        @DisplayName("Logs from range")
        public void logsFromRangeMarkdown() {
            LocalDate fromDate = LocalDate.parse("2015-05-23", DateTimeFormatter.ISO_DATE);
            LocalDate toDate = LocalDate.parse("2015-06-01", DateTimeFormatter.ISO_DATE);

            List<LogRecord> logRecordList = LOG_READER.readLogs(fromDate, toDate);
            Reporter reporter = new LogReporter(logRecordList);

            Assertions.assertEquals(GENERAL_INFORMATION_MARKDOWN_RANGE, reporter.generalInformation());
            Assertions.assertEquals(REQUEST_TYPES_MARKDOWN_RANGE, reporter.requestTypes());
            Assertions.assertEquals(RESPONSE_CODES_MARKDOWN_RANGE, reporter.responseCodes());
            Assertions.assertEquals(REQUESTED_RESOURCES_MARKDOWN_RANGE, reporter.requestedResources());
            Assertions.assertEquals(BUSIEST_DAYS_MARKDOWN_RANGE, reporter.busiestDays());
        }
    }
}
