package com.babkamen.proxy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Video {

    private String id;
    private String name;
    private String author;

}
