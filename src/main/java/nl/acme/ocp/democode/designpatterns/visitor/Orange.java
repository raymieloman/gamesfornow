package nl.acme.ocp.democode.designpatterns.visitor;

public class Orange extends Fruit{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
