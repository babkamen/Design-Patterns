import java.io.IOException;

public interface TreeFactory {
    public TreeType createTree(int treeType) throws IOException;
}
