package com.babkamen.proxy;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class ProxyTest {

    @Test
    void testProxy() {
        YoutubeService service = new CachingYoutubeService(new YoutubeServiceImpl());
        LoggingHandler loggingHandler = new LoggingHandler();
        assertTimeoutPreemptively(Duration.ofMillis(600), () -> listVideos(service, loggingHandler));
        //all entries should now be cached
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> getVideo(service, loggingHandler, "1"));
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> listVideos(service, loggingHandler));
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> getVideo(service, loggingHandler, "2"));

    }


    private static void listVideos(YoutubeService service, LoggingHandler loggingHandler) {
        System.out.println("Listing videos");
        List<Video> videos = loggingHandler.execute(service::listVideos);
        System.out.println("Videos " + videos);
    }

    private static void getVideo(YoutubeService service, LoggingHandler loggingHandler, String id) {
        System.out.println("Getting video");
        Video video = loggingHandler.execute(() -> service.getVideo(id));
        System.out.println("com.babkamen.proxy.Video " + video);
    }


}
