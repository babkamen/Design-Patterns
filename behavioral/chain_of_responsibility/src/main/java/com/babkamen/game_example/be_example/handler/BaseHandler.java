package com.babkamen.game_example.be_example.handler;

import com.babkamen.game_example.be_example.request.Request;

public abstract class BaseHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void execute(Request request) {
        if (nextHandler != null) {
            nextHandler.execute(request);
        }
    }
}
