package edu.project3.Utils;

import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class AdocUtils {
    private AdocUtils() {
    }

    public static @NotNull String createTable(String header, List<List<String>> tableRows) {
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

    @Contract(pure = true)
    private static @NotNull String createHeader(String header) {
        return "==== " + header + '\n';
    }

    @Contract(pure = true)
    private static @NotNull String createAttributes() {
        return "[format=\"csv\", options=\"header\"]" + '\n';
    }

    @Contract(pure = true)
    private static @NotNull String createTableLayout() {
        return "|===" + '\n';
    }

    private static @NotNull String createTableRow(@NotNull List<String> row) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : row) {
            stringBuilder.append(string)
                .append(",");
        }

        stringBuilder.append('\n');

        return stringBuilder.toString();
    }
}
