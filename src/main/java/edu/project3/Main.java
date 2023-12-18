package edu.project3;

import edu.project3.LogReader.LogFileReader;
import edu.project3.LogReader.LogReader;
import edu.project3.LogReader.LogURIReader;
import edu.project3.LogReporter.LogReporter;
import edu.project3.LogReporter.Reporter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@SuppressWarnings("RegexpSinglelineJava")
public final class Main {
    //    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PATH = "--path";
    private static final String FROM = "--from";
    private static final String TO = "--to";
    private static final String FORMAT = "--format";
    private static final List<String> COMMANDS = new ArrayList<>(List.of(PATH, FROM, TO, FORMAT));
    private static final List<String> ONLY_PATH = new ArrayList<>(List.of(PATH));
    private static final List<String> PATH_FROM = new ArrayList<>(List.of(PATH, FROM));
    private static final List<String> PATH_TO = new ArrayList<>(List.of(PATH, TO));
    private static final List<String> PATH_FORMAT = new ArrayList<>(List.of(PATH, FORMAT));
    private static final List<String> PATH_FROM_TO = new ArrayList<>(List.of(PATH, FROM, TO));
    private static final List<String> PATH_FROM_FORMAT = new ArrayList<>(List.of(PATH, FROM, FORMAT));
    private static final List<String> PATH_TO_FORMAT = new ArrayList<>(List.of(PATH, TO, FORMAT));
    private static final List<String> PATH_FROM_TO_FORMAT =
        new ArrayList<>(List.of(PATH, FROM, TO, FORMAT));
    private static final int ONE_ARGUMENT = 1;
    private static final int TWO_ARGUMENTS = 2;
    private static final int THREE_ARGUMENTS = 3;
    private static final int MAX_ARGUMENTS = 8;
    private static final int INDEX_PATH = 1;
    private static final int INDEX_FROM = 3;
    private static final int INDEX_TO = 5;

    private Main() {
    }

    public static void main(String[] args) {
        if (!isValidArgumentsLine(args)) {
            throw new IllegalArgumentException("Illegal arguments list");
        }

        List<String> arguments = getArgumentList(args);

        LogReader logReader = (isValidFilePath(args[INDEX_PATH])) ? new LogFileReader(Path.of(args[INDEX_PATH]))
            : new LogURIReader(args[INDEX_PATH]);
        List<LogRecord> logRecordList;

        if (new HashSet<>(arguments).containsAll(List.of(FROM, TO))) {
            logRecordList = logReader.readLogs(
                LocalDate.parse(args[INDEX_FROM], DateTimeFormatter.ISO_DATE),
                LocalDate.parse(args[INDEX_TO], DateTimeFormatter.ISO_DATE)
            );
        } else if (arguments.contains(FROM)) {
            logRecordList = logReader.readLogs(
                LocalDate.parse(args[INDEX_FROM], DateTimeFormatter.ISO_DATE),
                true
            );
        } else if (arguments.contains(TO)) {
            logRecordList = logReader.readLogs(
                LocalDate.parse(args[INDEX_FROM], DateTimeFormatter.ISO_DATE),
                false
            );
        } else {
            logRecordList = logReader.readLogs();
        }

        String format = (arguments.contains(FORMAT)) ? args[args.length - 1] : "markdown";

        Reporter reporter = new LogReporter(logRecordList, format);

//        LOGGER.info(reporter.generalInformation());
//        LOGGER.info(reporter.requestedResources());
//        LOGGER.info(reporter.responseCodes());
//        LOGGER.info(reporter.busiestDays());
//        LOGGER.info(reporter.requestTypes());
//        LOGGER.info(reporter.countUploadsBytesForEachDay());

        System.out.println(reporter.generalInformation());
        System.out.println(reporter.requestedResources());
        System.out.println(reporter.requestTypes());
        System.out.println(reporter.busiestDays());
        System.out.println(reporter.responseCodes());
        System.out.println(reporter.countUploadsBytesForEachDay());
    }

    private static boolean isValidArgumentsLine(String[] args) {
        return isValidArgumentsLength(args)
            && isValidArgumentsCommands(args)
            && isValidArgumentsSequence(args);
    }

    private static boolean isValidArgumentsLength(String[] args) {
        return (args.length >= 2) && (args.length % 2 == 0) && (args.length <= MAX_ARGUMENTS);
    }

    private static boolean isValidArgumentsCommands(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if (!COMMANDS.contains(args[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidArgumentsSequence(String[] args) {
        List<String> argumentsList = getArgumentList(args);
        int argumentsListSize = argumentsList.size();

        if (argumentsListSize == ONE_ARGUMENT) {
            return argumentsList.equals(ONLY_PATH);
        } else if (argumentsListSize == TWO_ARGUMENTS) {
            return argumentsList.equals(PATH_FROM)
                || argumentsList.equals(PATH_TO)
                || argumentsList.equals(PATH_FORMAT);
        } else if (argumentsListSize == THREE_ARGUMENTS) {
            return argumentsList.equals(PATH_FROM_TO)
                || argumentsList.equals(PATH_FROM_FORMAT)
                || argumentsList.equals(PATH_TO_FORMAT);
        } else {
            return argumentsList.equals(PATH_FROM_TO_FORMAT);
        }
    }

    private static boolean isValidFilePath(String path) {
        String regex = "[a-zA-Z]:\\\\((?:[a-zA-Z0-9() ]*\\\\)*).*";

        return Pattern.matches(regex, path);
    }

    private static List<String> getArgumentList(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < args.length; i += 2) {
            list.add(args[i]);
        }
        return list;
    }
}
