package com.github.wildbeavers.log4j12jsonlayout;

public class LogItem {
    private final String timestamp;
    private final String level;
    private final String logger;
    private final String thread;
    private final String message;
    private final String stacktrace;

    public LogItem(String timestamp, String level, String logger, String thread, String message, String stacktrace) {
        this.timestamp = timestamp;
        this.level = level;
        this.logger = logger;
        this.thread = thread;
        this.message = message;
        this.stacktrace = stacktrace;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getLogger() {
        return logger;
    }

    public String getThread() {
        return thread;
    }

    public String getMessage() {
        return message;
    }

    public String getStacktrace() {
        return stacktrace;
    }
}
