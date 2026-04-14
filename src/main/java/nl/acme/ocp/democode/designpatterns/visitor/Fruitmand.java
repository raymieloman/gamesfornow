package nl.acme.ocp.democode.designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fruitmand extends Fruit implements Iterable<Fruit> {
    private final List<Fruit> contents = new ArrayList<>();

    public void add(Fruit fruit) {
        contents.add(fruit);
    }

    @Override
    public Iterator<Fruit> iterator() {
        return this.contents.iterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
