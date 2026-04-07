package nl.acme.ocp.democode.desiignpatterns.visitor;

public class App {
    public static void main(String[] args) {
        Fruitmand mand = new Fruitmand();
        mand.add(new Apple());
        mand.add(new Pear());


        Visitor v = new FruitCountingVisitor();
        mand.accept(v);
        System.out.println(v);
    }
}
