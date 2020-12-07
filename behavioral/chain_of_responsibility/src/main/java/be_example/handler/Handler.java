package be_example.handler;

import be_example.request.Request;

public interface Handler {
    void setNext(Handler handler);
    void execute(Request request);
}
