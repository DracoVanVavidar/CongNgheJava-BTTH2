import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class Pipe {
    private int x, height;
    private final int width = 50, gap = 150;
    private Image topPipe, bottomPipe;

    public Pipe(int startX) {
        this.x = startX;
        this.height = new Random().nextInt(250) + 50;
        this.topPipe = new ImageIcon("assets/toppipe.png").getImage();
        this.bottomPipe = new ImageIcon("assets/bottompipe.png").getImage();
    }

    public void update() {
        x -= 5;
    }

    public void draw(Graphics g) {
        g.drawImage(topPipe, x, 0, width, height, null);
        g.drawImage(bottomPipe, x, height + gap, width, 640 - height - gap, null);
    }

    public int getX() {
        return x;
    }
}

public class Bai3 extends Bai2 {
    private ArrayList<Pipe> pipes;

    public Bai3() {
        super();
        this.pipes = new ArrayList<>();

        new Thread(() -> {
            while (true) {
                pipes.add(new Pipe(360));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pipe pipe : pipes) {
            pipe.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        pipes.forEach(Pipe::update);
        pipes.removeIf(pipe -> pipe.getX() < -50);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Bai3 panel = new Bai3();

        frame.add(panel);
        frame.setSize(360, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
