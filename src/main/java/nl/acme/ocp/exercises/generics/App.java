package nl.acme.ocp.exercises.generics;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Dog(), new Cat());
        AnimalDoctor.feedAnimals(animals);

        List<Cat> cats = List.of(new Cat());
        AnimalDoctor.feedSomeAnimals(cats);
//        AnimalDoctor.feedAnimals(cats); // fails, why? =>
        // since we have to supply a list of the exact type Animal
        // and that is not the case

        List<Cat> catList = new ArrayList<>();
//        AnimalDoctor.addSomeAnimals(catList); // fails, why? =>
        // since we have to supply a List<Animal> or List<Objecgt>
        // lower bound is Animal
    }
}
