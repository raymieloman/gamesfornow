package nl.acme.ocp.democode.trywithresources;

import java.util.ArrayList;
import java.util.List;

public class Box<T> implements AutoCloseable {

    private List<T> contents = new ArrayList<>();

    public void add(T t) {
        this.contents.add(t);
    }

    @Override
    public void close()  {
        System.out.println("Box is closed");
    }
}
