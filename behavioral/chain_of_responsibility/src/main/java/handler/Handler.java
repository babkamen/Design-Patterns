package handler;

import request.Request;

public interface Handler {
    void setNext(Handler handler);
    void execute(Request request);
}
