package nl.acme.ocp.democode.desiignpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fruitmand extends Fruit implements Iterable<Fruit> {
    private final List<Fruit> content = new ArrayList<>();

    @Override
    void accept(Visitor visitor) {
        for (Fruit f : this) {
            f.accept(visitor);
        }
    }

    public void add(Fruit fruit) {
        this.content.add(fruit);
    }

    @Override
    public Iterator<Fruit> iterator() {
        return this.content.iterator();
    }
}
