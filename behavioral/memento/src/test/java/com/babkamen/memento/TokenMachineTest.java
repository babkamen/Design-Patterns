package com.babkamen.memento;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenMachineTest {

    @Test
    public void basicTest() {
        TokenMachine tokenMachine = new TokenMachine();
        Memento m1 = tokenMachine.addToken(1);
        assertEquals(1, m1.getTokens().size());

        Token token = new Token(2);
        Memento m2 = tokenMachine.addToken(token);
        assertEquals(2, m2.getTokens().size());

        token.setValue(3);
        assertEquals(List.of(1, 2), m2.getTokens().stream().map(Token::getValue).collect(Collectors.toList()));

        tokenMachine.revert(m1);
        assertEquals(List.of(1), tokenMachine.getTokens().stream().map(Token::getValue).collect(Collectors.toList()));

        tokenMachine.addToken(4);
        tokenMachine.addToken(5);
        tokenMachine.revert(m2);
        assertEquals(List.of(1, 2), tokenMachine.getTokens().stream().map(Token::getValue).collect(Collectors.toList()));
    }
}