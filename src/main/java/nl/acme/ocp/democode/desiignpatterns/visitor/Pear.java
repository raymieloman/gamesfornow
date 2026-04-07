package nl.acme.ocp.democode.desiignpatterns.visitor;

public class Pear extends Fruit {
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);

    }
}
