package org.example.tirepressure;

public class Alarm {
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;

    Sensible sensor;

    boolean alarmOn = false;

    public Alarm() {
        this(new Sensor(), new Threshold(17, 21));
    }

    public Alarm(Sensible sensor, Threshold threshold) {
        LowPressureThreshold = threshold.low();
        HighPressureThreshold = threshold.high();
        this.sensor = sensor;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}