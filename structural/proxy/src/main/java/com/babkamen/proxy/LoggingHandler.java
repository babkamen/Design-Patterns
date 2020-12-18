package com.babkamen.proxy;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class LoggingHandler {

    <T> T execute(Supplier<T> c) {
        Instant start = Instant.now();
        T result = null;
        try {
            result = c.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println("Request took " +
                DateTimeFormatter.ISO_LOCAL_TIME.format(between.addTo(LocalTime.of(0, 0))));
        return result;
    }
}
