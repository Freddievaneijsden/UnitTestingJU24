package org.example.tirepressure;

public class FixedSensor implements Sensible {
    public static final double OFFSET = 16;
    public double fixedValueForTest;

    public double popNextPressurePsiValue() {
        double pressureTelemetryValue;
        pressureTelemetryValue = samplePressure();

        return OFFSET + pressureTelemetryValue;
    }

    private static double samplePressure() {
        // placeholder implementation that simulate a real sensor in a real tire
        return 6 * 1 * 1;
    }
}
