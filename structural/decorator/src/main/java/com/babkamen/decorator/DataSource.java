package com.babkamen.decorator;

public interface DataSource {

    void writeData(byte[] data);

    byte[] readData();
}
