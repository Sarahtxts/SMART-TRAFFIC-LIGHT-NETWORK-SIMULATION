/**
 * Controls the state transitions of the traffic light.
 */
public class TrafficController implements Runnable {
    private LightState currentState = LightState.RED;
    private final int cycleDelay; // in milliseconds
    private boolean running = true;

    public TrafficController(int cycleDelay) {
        this.cycleDelay = cycleDelay;
    }

    public LightState getCurrentState() {
        return currentState;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(cycleDelay);
                currentState = currentState.next();
                System.out.println("Traffic Light changed to: " + currentState);
            } catch (InterruptedException e) {
                System.err.println("TrafficController interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
