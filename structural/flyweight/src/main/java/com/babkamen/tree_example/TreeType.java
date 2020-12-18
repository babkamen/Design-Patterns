package com.babkamen.tree_example;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@ToString
@Builder
public class TreeType {

    private String name;
    private Color color;
    private BufferedImage sprite;
}
