import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FatTreeFactory implements TreeFactory {

    private Map<Integer, BufferedImage> map = new HashMap<>();

    public TreeType createTree(int treeType) throws IOException {
        if (map.get(treeType) == null) {
            loadImage(treeType);
        }
        return TreeType.builder().color(Color.BLUE).name("tree").sprite(map.get(treeType)).build();
    }

    private void loadImage(int treeType) throws IOException {
        InputStream stream = FlyweightTreeFactory.class.getResourceAsStream("tree-" + treeType + ".png");
        map.put(treeType, ImageIO.read(stream));

    }

}
