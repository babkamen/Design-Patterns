package com.babkamen.tree_example;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FlyweightTreeFactory implements TreeFactory {

    private Map<Integer, TreeType> map = new HashMap<>();

    public TreeType createTree(int treeType) throws IOException {
        if (map.get(treeType) == null) {
            loadImage(treeType);
        }
        return map.get(treeType);
    }

    private void loadImage(int treeType) throws IOException {
        InputStream stream = FlyweightTreeFactory.class.getResourceAsStream("tree-" + treeType + ".png");
        TreeType tree = TreeType.builder().name("tree").sprite(ImageIO.read(stream)).build();
        map.put(treeType, tree);

    }

}
