package com.babkamen.game_example.be_example.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException() {
        super("Access is denied");
    }
}
