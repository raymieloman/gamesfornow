package nl.acme.ocp.democode.designpatterns.visitor;

public class FruitCountingVisitor implements Visitor {


    @Override
    public void visit(Apple apple) {
        System.out.println("Ik ben een apple");

    }

    @Override
    public void visit(Orange orange) {
        System.out.println("Ik ben een orange");
    }

    @Override
    public void visit(Pear pear) {
        System.out.println("Ik ben een pear");
    }

    @Override
    public void visit(Fruitmand fruitmand) {
        for (Fruit f : fruitmand) {
            f.accept(this);
        }
    }
}
