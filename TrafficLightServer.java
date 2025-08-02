import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server that manages incoming vehicle connections and traffic control.
 */
public class TrafficLightServer {
    private static final int PORT = 5000;
    private final TrafficController controller;
    private boolean running = true;

    public TrafficLightServer() {
        controller = new TrafficController(3000); // 3-second cycle
        new Thread(controller).start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Traffic Light Server started on port " + PORT);

            while (running) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new VehicleHandler(clientSocket, controller)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public void stop() {
        running = false;
        controller.stop();
        System.out.println("Server stopped.");
    }

    public static void main(String[] args) {
        TrafficLightServer server = new TrafficLightServer();
        server.start();
    }
}
