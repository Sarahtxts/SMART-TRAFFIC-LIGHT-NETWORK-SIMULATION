import java.awt.*;
import javax.swing.*;

/**
 * Simple GUI to display the traffic light.
 */
public class TrafficLightGUI extends JFrame {
    private final TrafficController controller;

    public TrafficLightGUI(TrafficController controller) {
        this.controller = controller;
        setTitle("Traffic Light Simulation");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Timer for periodic repaint
        new Timer(500, e -> repaint()).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        LightState state = controller.getCurrentState();
        g.setColor(Color.BLACK);
        g.fillRect(50, 70, 100, 260);

        g.setColor(state == LightState.RED ? Color.RED : Color.DARK_GRAY);
        g.fillOval(75, 80, 50, 50);

        g.setColor(state == LightState.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
        g.fillOval(75, 160, 50, 50);

        g.setColor(state == LightState.GREEN ? Color.GREEN : Color.DARK_GRAY);
        g.fillOval(75, 240, 50, 50);
    }

    /**
     * Run GUI independently for testing/demo.
     */
    public static void main(String[] args) {
        TrafficController controller = new TrafficController(3000); // 3s cycle
        new Thread(controller).start();

        SwingUtilities.invokeLater(() -> {
            TrafficLightGUI gui = new TrafficLightGUI(controller);
            gui.setVisible(true);
        });
    }
}
