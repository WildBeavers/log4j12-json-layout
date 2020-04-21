package com.github.wildbeavers.log4j12jsonlayout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonLayout extends Layout {
    private static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    private final ObjectMapper om;
    private SimpleDateFormat dateFormat;

    public JsonLayout() {
        this.om = new ObjectMapper();
        this.om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
    }

    public void activateOptions() {
    }

    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public String format(LoggingEvent loggingEvent) {
        Date timestamp = new Date(loggingEvent.getTimeStamp());

        String stacktrace = null;

        if (loggingEvent.getThrowableStrRep() != null) {
            stacktrace = String.join("\n", loggingEvent.getThrowableStrRep());
        }

        LogItem li = new LogItem(
                this.dateFormat.format(timestamp),
                loggingEvent.getLevel().toString(),
                loggingEvent.getLoggerName(),
                loggingEvent.getThreadName(),
                loggingEvent.getMessage().toString(),
                stacktrace
        );

        String out;

        try {
            out = om.writeValueAsString(li);
        } catch (JsonProcessingException e) {
            return "JsonLayout - ERROR formatting log message\n";
        }

        return out + "\n";
    }

    public void setDatePattern(String pattern) {
        try {
            this.dateFormat = new SimpleDateFormat(pattern);
        } catch (Exception e) {
            this.dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
        }
    }
}
