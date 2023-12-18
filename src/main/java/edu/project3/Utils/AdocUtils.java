package edu.project3.Utils;

import java.util.List;

public final class AdocUtils {
    private AdocUtils() {
    }

    public static String createTable(String header, List<List<String>> tableRows) {
        if (!MarkdownUtils.isValidTable(tableRows)) {
            throw new IllegalArgumentException("Wrong table");
        }

        StringBuilder stringBuilder = new StringBuilder().append(createHeader(header))
            .append(createAttributes())
            .append(createTableLayout());
        for (List<String> row : tableRows) {
            stringBuilder.append(createTableRow(row));
        }
        stringBuilder.append(createTableLayout())
            .append('\n');
        return stringBuilder.toString();
    }

    private static String createHeader(String header) {
        return "==== " + header + '\n';
    }

    private static String createAttributes() {
        return "[format=\"csv\", options=\"header\"]" + '\n';
    }

    private static String createTableLayout() {
        return "|===" + '\n';
    }

    private static String createTableRow(List<String> row) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : row) {
            stringBuilder.append(string)
                .append(",");
        }
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}
