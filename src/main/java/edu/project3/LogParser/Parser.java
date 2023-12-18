package edu.project3.LogParser;

import edu.project3.LogRecord;

public interface Parser {
    LogRecord parse(String logString);
}
