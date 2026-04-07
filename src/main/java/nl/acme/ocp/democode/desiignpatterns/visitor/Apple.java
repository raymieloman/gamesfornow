package nl.acme.ocp.democode.desiignpatterns.visitor;

public class Apple extends  Fruit{
    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
