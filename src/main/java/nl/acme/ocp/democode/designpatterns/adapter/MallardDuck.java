package nl.acme.ocp.democode.designpatterns.adapter;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quacking Mallard Duck");
    }

    @Override
    public void fly() {
        System.out.println("Flying Mallard Duck");

    }

    @Override
    public void swim() {
        System.out.println("Swimming Mallard Duck");
    }
}
