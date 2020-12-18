package com.babkamen.game_example.be_example.handler;

import com.babkamen.game_example.be_example.request.Request;

public interface Handler {

    void setNext(Handler handler);

    void execute(Request request);
}
