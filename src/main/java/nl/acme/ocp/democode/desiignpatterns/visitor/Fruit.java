package nl.acme.ocp.democode.desiignpatterns.visitor;

public abstract class Fruit {
    abstract void accept(Visitor visitor);
}
