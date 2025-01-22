package org.example.tirepressure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {

    @Test
    @DisplayName("AlarmOnIsTrueAfterCheckMethod")
    void alarmOnIsTrueAfterCheckMethod() {
        Threshold threshold = new Threshold(20.0, 21.0);
        FixedSensor sensor = new FixedSensor();
        Alarm alarm = new Alarm(sensor, threshold);

        alarm.check();
        boolean alarmIsOn = alarm.isAlarmOn();

        assertThat(alarmIsOn).isTrue();
    }

    @Test
    @DisplayName("AlarmOnIsFalseAfterCheckMethod")
    void alarmOnIsFalseAfterCheckMethod() {
        Alarm alarm = new Alarm();

        alarm.check();
        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    @DisplayName("AssertThatPopNextPressurePsiValueReturns22")
    void assertThatPopNextPressurePsiValueReturns22() {
        FixedSensor sensor = new FixedSensor();
        double result = sensor.popNextPressurePsiValue();
        assertThat(result).isEqualTo(22.0);
    }

}