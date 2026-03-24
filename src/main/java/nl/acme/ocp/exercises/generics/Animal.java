package nl.acme.ocp.exercises.generics;

public class Animal implements Comparable<Animal> {

    private double weight = 3.0;
    private int age = 45;

    public void eat() {
        this.weight += 0.1;
    }

    @Override
    public int compareTo(Animal that) {
//        return (int) (this.weight*1000) - (int) (o.weight * 1000);
        return this.age - that.age;
    }
}

