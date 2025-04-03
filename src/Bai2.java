import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Bird {
    private int x, y, velocity;
    private Image birdImage;

    public Bird() {
        this.x = 100;
        this.y = 300;
        this.velocity = 0;
        this.birdImage = new ImageIcon("assets/flappybird.png").getImage();
    }

    public void update() {
        velocity += 1; // Trọng lực
        y += velocity;
        if (y > 600) y = 600; // Không rơi khỏi màn hình
    }

    public void jump() {
        velocity = -10; // Chim bay lên
    }

    public void draw(Graphics g) {
        g.drawImage(birdImage, x, y, 40, 40, null);
    }

    public int getY() {
        return y;
    }
}

public class Bai2 extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Bird bird;
    private Image background;

    public Bai2() {
        this.setFocusable(true);
        this.addKeyListener(this);
        this.background = new ImageIcon("assets/flappybirdbg.png").getImage();
        this.bird = new Bird();

        this.timer = new Timer(16, this);
        this.timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        bird.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
            bird.jump();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Bai2 panel = new Bai2();

        frame.add(panel);
        frame.setSize(360, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
