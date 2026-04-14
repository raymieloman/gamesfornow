package nl.acme.ocp.democode.designpatterns.visitor;

// in real life, mostly this class is called 'Node'
public abstract class Fruit {
    public abstract void accept(Visitor visitor);
}
