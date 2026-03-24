package nl.acme.ocp.exercises.timetable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TrainSchedule {
    // ! The type for NavigableSet must implement the interface Comparable
    /*
    e.g. for Animal: implements Comparable<Animal>
     */
    private NavigableSet<LocalTime> schedule = new TreeSet<>();

    public TrainSchedule() {
        this.schedule.addAll(Arrays.asList(LocalTime.of(10, 30), LocalTime.of(9, 30),
                LocalTime.of(13, 15), LocalTime.of(16, 30)));
    }

    public LocalTime getTimeBefore(LocalTime time) {
        return schedule.floor(time);
    }

    public LocalTime getTimeAfter(LocalTime time) {
        return schedule.ceiling(time);
    }
}
