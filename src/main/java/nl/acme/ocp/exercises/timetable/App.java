package nl.acme.ocp.exercises.timetable;

import java.time.LocalTime;

import static nl.acme.utils.Assertion.assertEquals;

public class App {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();
        LocalTime time = schedule.getTimeAfter(LocalTime.of(10,00));

        assertEquals(LocalTime.of(10,30), time);
    }
}
