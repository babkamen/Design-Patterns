import exception.AccessDeniedException;
import handler.AuthenticationHandler;
import handler.StatisticsHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import request.AuthenticatedRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandlersTest {

    public static final String URL = "/get/1";

    @Test
    public void happyPath() {
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
    public void authenticationHandlerTest() {
        AuthenticationHandler authHandler = new AuthenticationHandler();
        StatisticsHandler statisticsHandler = new StatisticsHandler();
        statisticsHandler.setNext(authHandler);

        AuthenticatedRequest authenticatedRequest = AuthenticatedRequest.builder()
                .url(URL)
                .username("admin1")
                .password("password")
                .build();

        Assertions.assertThrows(AccessDeniedException.class, () -> {
            statisticsHandler.execute(authenticatedRequest);
        });

    }
}
