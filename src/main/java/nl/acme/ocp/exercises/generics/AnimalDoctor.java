package nl.acme.ocp.exercises.generics;

import java.util.List;

public final class AnimalDoctor {


    public static void main(String[] args) {
        int a = 4;
        poedel(a);
        System.out.println(a);
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

    static void poedel(final int age) {
//        ++age;
    }

    public static void addSomeAnimals(List<?super Animal> animals) {
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Bird());
    }

    private AnimalDoctor() {
    }
}
