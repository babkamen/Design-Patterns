package com.babkamen.stock_example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@RequiredArgsConstructor
public abstract class Order {

    @NonNull
    protected StockOperationType type;
    private String id = UUID.randomUUID().toString();

    public abstract void execute();
}
