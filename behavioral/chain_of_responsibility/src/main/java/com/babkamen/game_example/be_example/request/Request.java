package com.babkamen.game_example.be_example.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Request {

    private String url;
}
