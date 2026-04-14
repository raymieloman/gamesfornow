package nl.acme.ocp.democode.designpatterns.visitor;

public abstract class Fruit {
    public abstract void accept(Visitor visitor);
}
