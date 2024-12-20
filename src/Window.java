import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    public final int WINDOW_WIDTH;
    public final int WINDOW_HEIGHT;
    public final int FRAME_RATE;

    public Window(int width, int height, int fps) {

        this.WINDOW_WIDTH = width;
        this.WINDOW_HEIGHT = height;
        this.FRAME_RATE = fps;

        setTitle("Physics Simulation");
        setIconImage(new ImageIcon("resources/ball.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Simulation simulation = new Simulation(-9.81f, width, height, 1f / FRAME_RATE);


        add(simulation);

        pack();
        setResizable(false);
        setVisible(true);

        for (int i = 0; i < 5; i++) {
            simulation.addBall(30, 12, 2 * i, 2 * i, 0, 0, 2, 1);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window(1600, 900, 60));
    }
}
