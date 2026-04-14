package nl.acme.ocp.democode.designpatterns.visitor;

public class Pear extends Fruit {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
