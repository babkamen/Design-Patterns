package com.babkamen.null_object;

import java.util.Iterator;
import java.util.stream.Stream;

public class NullLog implements Log {

    private Iterator<Integer> infiniteStreamIterator = Stream.iterate(0, i -> i + 1).iterator();

    @Override
    public int getRecordLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getRecordCount() {
        return infiniteStreamIterator.next();
    }

    @Override
    public void logInfo(String message) {
        //shouldn't log this in null log
    }
}