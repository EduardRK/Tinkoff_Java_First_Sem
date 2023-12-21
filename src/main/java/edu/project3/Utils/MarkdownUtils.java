package edu.project3.Utils;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class MarkdownUtils {
    private MarkdownUtils() {
    }

    public static @NotNull String createTable(String header, List<List<String>> tableRows) {
        if (!isValidTable(tableRows)) {
            throw new IllegalArgumentException("Wrong table");
        }

        List<Integer> sizeList = rowsSize(tableRows);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(createHeader(header))
            .append('\n')
            .append(createTableRow(tableRows.get(0), sizeList))
            .append(createTableLayout(sizeList));

        for (int i = 1; i < tableRows.size(); ++i) {
            stringBuilder.append(createTableRow(tableRows.get(i), sizeList));
        }

        return stringBuilder.toString();
    }

    @Contract(pure = true)
    private static @NotNull String createHeader(String header) {
        return "#### " + header + '\n';
    }

    private static @NotNull List<Integer> rowsSize(@NotNull List<List<String>> tableRows) {
        List<Integer> sizeList = new ArrayList<>();
        int cols = tableRows.get(0).size();

        for (int col = 0; col < cols; ++col) {
            int maxSize = 0;
            for (List<String> tableRow : tableRows) {
                maxSize = Math.max(tableRow.get(col).length(), maxSize);
            }
            sizeList.add(maxSize + 2);
        }

        return sizeList;
    }

    private static @NotNull String createTableRow(@NotNull List<String> row, List<Integer> sizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < row.size() - 1; ++i) {
            stringBuilder.append("|")
                .append(createTableCell(row.get(i), sizes.get(i)));
        }

        stringBuilder.append("|")
            .append(String.format("%" + sizes.get(sizes.size() - 1) + "s", row.get(row.size() - 1)))
            .append("|")
            .append('\n');

        return stringBuilder.toString();
    }

    private static @NotNull String createTableLayout(@NotNull List<Integer> sizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sizes.size() - 1; ++i) {
            stringBuilder.append("|")
                .append(":")
                .append("-".repeat(sizes.get(i) - 2))
                .append(":");
        }

        stringBuilder.append("|")
            .append("-".repeat(sizes.get(sizes.size() - 1) - 1))
            .append(":")
            .append("|")
            .append('\n');

        return stringBuilder.toString();
    }

    private static @NotNull String createTableCell(@NotNull String string, int size) {
        int spaces = size - string.length();
        int leftPad = spaces / 2;
        int rightPad = (leftPad * 2 == spaces) ? leftPad : leftPad + 1;
        return " ".repeat(leftPad) + string + " ".repeat(rightPad);
    }

    static boolean isValidTable(@NotNull List<List<String>> tableRows) {
        int size = tableRows.get(0).size();

        for (List<String> list : tableRows) {
            if (list.size() != size) {
                return false;
            }
        }

        return true;
    }
}
