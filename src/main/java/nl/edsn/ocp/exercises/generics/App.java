package nl.edsn.ocp.exercises.generics;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat());
        AnimalDoctor.feedAnimals(animals);

        List<Cat> cats = List.of(new Cat());
        AnimalDoctor.feedSomeAnimals(cats);
//        AnimalDoctor.feedAnimals(cats); // fails, why

        List<Cat> catList = new ArrayList<>();
//        AnimalDoctor.addSomeAnimals(catList); // fails, why
    }
}
