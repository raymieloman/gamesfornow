package nl.acme.ocp.democode.designpatterns.visitor;

public class App {

    public static void main(String[] args) {
        Fruitmand mand = new Fruitmand();
        mand.add(new Apple());
        mand.add(new Orange());
        mand.add(new Pear());

        Visitor fruitCountingVisitor = new FruitCountingVisitor();
        mand.accept(fruitCountingVisitor);

//        for (Fruit f : mand) {
//            f.accept(fruitCountingVisitor);
//        }
    }
}
