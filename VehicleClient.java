import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Simulates a vehicle connecting to the traffic light server.
 */
public class VehicleClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Vehicle arrived");
            String response = in.readLine();
            System.out.println("Traffic Light State: " + response);

        } catch (IOException e) {
            System.err.println("VehicleClient error: " + e.getMessage());
        }
    }
}
