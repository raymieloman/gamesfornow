package nl.acme.ocp.democode.desiignpatterns.visitor;

public interface Visitor {
    void visit(Apple apple);

    void visit(Pear pear);
}
