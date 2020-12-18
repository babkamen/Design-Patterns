package com.babkamen.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DelegationDataSourceDecorator implements DataSource {

    protected DataSource delegate;

    @Override
    public void writeData(byte[] data) {
        delegate.writeData(data);
    }

    @Override
    public byte[] readData() {
        return delegate.readData();
    }
}
