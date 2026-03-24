package nl.edsn.ocp.exercises.generics;

import java.util.List;

public final class AnimalDoctor {

    private AnimalDoctor() {
    }

    public static void feedAnimals(List<Animal> animals) {
        for(Animal animal: animals) {
            animal.eat();
        }
    }

    public static void feedSomeAnimals(List<? extends Animal> animals) {
        for(Animal animal: animals) {
            animal.eat();
        }
    }

    public static void addSomeAnimals(List<?super Animal> animals) {
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Bird());
    }
}
