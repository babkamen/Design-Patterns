package com.babkamen.null_object;

public class Account {

    private Log log;

    public Account(Log log) {
        System.out.println("Constructed account.null_object.Log=" + log.getClass().getSimpleName());
        this.log = log;
    }

    public void someOperation() throws Exception {
        System.out.println("In some operation");
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        int recordCount = log.getRecordCount();
        if (c + 1 != recordCount) {
            throw new Exception(String.format("Record should be %s but is %s", c + 1, recordCount));
        }
        if (log.getRecordCount() >= log.getRecordLimit()) {
            throw new Exception();
        }
    }
}
