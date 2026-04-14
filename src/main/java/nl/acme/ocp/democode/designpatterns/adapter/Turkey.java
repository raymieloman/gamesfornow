package nl.acme.ocp.democode.designpatterns.adapter;

public class Turkey {

    public void gobble() {
        System.out.println("Gobble gobble");
    }

    public void hop() {
        System.out.println("I'm flying a short distance");
    }

    public void eat() {
        System.out.println("Turkey eating");
    }

    public void garbageCollect() {
        System.out.println("Garbage collecting");
    }
}
