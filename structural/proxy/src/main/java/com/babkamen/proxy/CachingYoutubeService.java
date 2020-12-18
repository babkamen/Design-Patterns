package com.babkamen.proxy;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CachingYoutubeService implements YoutubeService {

    private final YoutubeService service;
    private Map<String, Video> cache = new HashMap<>();

    @Override
    public List<Video> listVideos() {
        if (cache.isEmpty()) {
            List<Video> videos = service.listVideos();
            cache = videos.stream().collect(Collectors.toMap(Video::getId, Function.identity()));
            return videos;
        } else {
            return new ArrayList<>(cache.values());
        }
    }

    @Override
    public Video getVideo(String id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            Video video = service.getVideo(id);
            cache.put(id, video);
            return video;
        }
    }
}
