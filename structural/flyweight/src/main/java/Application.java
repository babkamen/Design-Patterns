import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Application extends JFrame {

    public Application() throws IOException {

        initUI();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {
                Application ex = new Application();
                ex.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initUI() throws IOException {
        setSize(800, 600);
        add(new Forest(this, new FlyweightTreeFactory(), 1_000_000));


        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}