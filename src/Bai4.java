public class Bai4 extends Bai3 {
    private boolean isGameOver;

    public Bai4() {
        super();
        this.isGameOver = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            super.actionPerformed(e);
            for (Pipe pipe : pipes) {
                if (pipe.isColliding(bird)) {
                    isGameOver = true;
                }
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over!", 80, 320);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press ENTER to Restart", 60, 350);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        Bai4 panel = new Bai4();

        frame.add(panel);
        frame.setSize(360, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
