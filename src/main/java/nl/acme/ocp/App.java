package nl.acme.ocp.navigable;

import java.util.NavigableSet;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        NavigableSet<String> timetable = new TreeSet<>();
        timetable.add("09:30");
        timetable.add("10:30");
        timetable.add("10:45");
        timetable.add("999");
        timetable.add("1000");
        timetable.add("10:00");
        timetable.add("1001");

        System.out.println("Dit is een COLON");
        System.out.println((char) (':'));
        System.out.println("Dit is einde van een COLON");

        // ik kom aan op het station om 10:33, wanneer gaat mijn

        // vorige trein
        System.out.println(timetable.floor("10:33"));
        //volgende trein
        System.out.println(timetable.ceiling("10:33"));

        System.out.println(timetable.floor("1000"));
        System.out.println(timetable.ceiling("888"));
        System.out.println("Hieronder alle elementen: ");
        for (String element : timetable) {
            System.out.println(element);
        }
    }
}
