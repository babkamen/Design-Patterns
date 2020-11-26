import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YoutubeServiceImpl implements YoutubeService {
    private static Map<String, Video> videos = new LinkedHashMap<>();

    static {
        videos.put("1", Video.builder().id("1").name("Some video").author("Hew Jackman").build());
        videos.put("2", Video.builder().id("2").name("Video about cats").author("Hew Jackman").build());
        videos.put("3", Video.builder().id("3").name("My new shiny car").author("Hew Jackman").build());
        videos.put("4", Video.builder().id("4").name("Roller Coaster in the shower").author("Hew Jackman").build());
        videos.put("5", Video.builder().id("5").name("Aggravating adventure of my cat in speedos").author("Hew Jackman").build());
        videos.put("6", Video.builder().id("6").name("49 shades of mirror table ").author("Hew Jackman").build());
    }

    @Override
    public List<Video> listVideos() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(videos.values());
    }

    @Override
    public Video getVideo(String id) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return videos.get(id);
    }
}
