import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Application extends JFrame {

    public Application() throws IOException {

        initUI();
    }

    private void initUI() throws IOException {
        setSize(800, 600);
        add(new Forest(this, new FlyweightTreeFactory(), 1_000_000));


        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Application ex = null;
            try {
                ex = new Application();
                ex.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}