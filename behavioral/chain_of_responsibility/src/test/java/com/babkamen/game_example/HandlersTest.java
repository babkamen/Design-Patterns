package com.babkamen.game_example;

import com.babkamen.game_example.be_example.exception.AccessDeniedException;
import com.babkamen.game_example.be_example.handler.AuthenticationHandler;
import com.babkamen.game_example.be_example.handler.StatisticsHandler;
import com.babkamen.game_example.be_example.request.AuthenticatedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandlersTest {

    public static final String URL = "/get/1";

    @Test
    void happyPath() {
        AuthenticationHandler authHandler = new AuthenticationHandler();
        StatisticsHandler statisticsHandler = new StatisticsHandler();
        statisticsHandler.setNext(authHandler);

        AuthenticatedRequest authenticatedRequest = AuthenticatedRequest.builder()
                .url(URL)
                .username("admin")
                .password("password")
                .build();
        statisticsHandler.execute(authenticatedRequest);

        assertEquals(statisticsHandler.getUsedUrls(), List.of(URL));
    }

    @Test
    void authenticationHandlerTest() {
        AuthenticationHandler authHandler = new AuthenticationHandler();
        StatisticsHandler statisticsHandler = new StatisticsHandler();
        statisticsHandler.setNext(authHandler);

        AuthenticatedRequest authenticatedRequest = AuthenticatedRequest.builder()
                .url(URL)
                .username("admin1")
                .password("password")
                .build();

        Assertions.assertThrows(AccessDeniedException.class, () ->
                statisticsHandler.execute(authenticatedRequest));

    }
}
