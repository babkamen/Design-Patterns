package com.babkamen.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SingletonEnum {
    INSTANCE("lorem ipsum");
    private String content;
}
