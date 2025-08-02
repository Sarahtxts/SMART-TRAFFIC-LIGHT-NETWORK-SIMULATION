/**
 * Enum representing the state of a traffic light.
 */
public enum LightState {
    RED,
    YELLOW,
    GREEN;

    /**
     * Returns the next light state in sequence.
     */
    public LightState next() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                return RED;
        }
    }
}
