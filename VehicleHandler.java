import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Handles communication with a single vehicle.
 */
public class VehicleHandler implements Runnable {
    private final Socket socket;
    private final TrafficController controller;

    public VehicleHandler(Socket socket, TrafficController controller) {
        this.socket = socket;
        this.controller = controller;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String request = in.readLine();
            System.out.println("Vehicle Request: " + request);

            LightState state = controller.getCurrentState();
            out.println(state.name());

        } catch (IOException e) {
            System.err.println("VehicleHandler error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
