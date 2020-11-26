import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forest extends JPanel {
    private final List<Tree> trees = new ArrayList<>();
    private final JLabel text = new JLabel();

    public Forest(Component parent, TreeFactory treeFactory, int treeCount) throws IOException {
        int width = parent.getWidth();
        int height = parent.getHeight();
        Random random = new Random();
        for (int i = 0; i < treeCount; i++) {
            trees.add(new Tree(random.nextInt(width), random.nextInt(height), treeFactory.createTree(1 + random.nextInt(2))));
        }
        text.setFont(new Font(text.getFont().getName(), Font.PLAIN, 32));
        text.setForeground(Color.RED);
        add(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Tree tree : trees) {
            g.drawImage(tree.getTreeType().getSprite(), tree.getX(), tree.getY(), this);
        }
        int memory = (int) Math.round((double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        text.setText("KB: " + memory);

        Toolkit.getDefaultToolkit().sync();

    }

}
