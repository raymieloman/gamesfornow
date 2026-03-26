package nl.acme.ocp.democode.varring;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        var lijst = new ArrayList<String>();
        // var is nog steeds wel een statische variable
        lijst.add("a");
        lijst.add("b");

        var nogEenLijst = new ArrayList<>(lijst);
        System.out.println(nogEenLijst);

        lijst = null;

//        lijst = new ArrayList<Integer>(); // fails
    }
}
