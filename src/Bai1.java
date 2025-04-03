import javax.swing.*;
import java.awt.*;

public class Bai1 extends JPanel {
    private Image background;

    public Bai1() {
        this.background = new ImageIcon("assets/flappybirdbg.png").getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Bai1 panel = new Bai1();

        frame.add(panel);
        frame.setSize(360, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
