package com.babkamen.proxy;

import java.util.List;

public interface YoutubeService {

    List<Video> listVideos();

    Video getVideo(String id);
}
