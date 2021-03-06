package com.babkamen.memento;

import java.util.List;
import java.util.stream.Collectors;

public class Memento {

    private final List<Token> tokens;

    public Memento(List<Token> tokens) {
        this.tokens = tokens.stream().map(Token::getValue).map(Token::new).collect(Collectors.toList());
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
