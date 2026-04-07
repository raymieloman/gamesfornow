package nl.acme.ocp.democode.desiignpatterns.visitor;

// look no instanceof invocation needed when using
// a lot of subclasses and doing something special per subclass
public class FruitCountingVisitor implements  Visitor {
    private int apples;
    private int pears;

    @Override
    public void visit(Apple apple) {
        this.apples++;
    }

    @Override
    public void visit(Pear pear) {
        pears++;
    }

    @Override
    public String toString() {
        return "FruitCountingVisitor{" +
                "apples=" + apples +
                ", pears=" + pears +
                '}';
    }
}
