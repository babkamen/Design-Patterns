import java.util.List;

public class YoutubeManager {

    public static void main(String[] args) {
        YoutubeService service = new CachingYoutubeService(new YoutubeServiceImpl());
        LoggingHandler loggingHandler = new LoggingHandler();
        listVideos(service, loggingHandler);
        getVideo(service, loggingHandler, "1");

        listVideos(service, loggingHandler);
        getVideo(service, loggingHandler, "1");
    }

    private static void listVideos(YoutubeService service, LoggingHandler loggingHandler) {
        System.out.println("Listing videos");
        List<Video> videos = loggingHandler.execute(service::listVideos);
        System.out.println("Videos " + videos);
    }

    private static void getVideo(YoutubeService service, LoggingHandler loggingHandler, String id) {
        System.out.println("Getting video");
        Video video = loggingHandler.execute(() -> service.getVideo(id));
        System.out.println("Video " + video);
    }

}
