package nl.acme.ocp.democode.designpatterns.visitor;

public interface Visitor {
    void visit(Apple apple);
    void visit(Orange orange);
    void visit(Pear pear);
    void visit(Fruitmand fruitmand);
}
