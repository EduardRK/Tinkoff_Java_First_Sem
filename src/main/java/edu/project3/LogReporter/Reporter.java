package edu.project3.LogReporter;

public interface Reporter {
    String generalInformation();

    String requestedResources();

    String responseCodes();

    String busiestDays();

    String requestTypes();

    String countUploadsBytesForEachDay();
}
