package nl.acme.ocp.democode.designpatterns.adapter;

public class TurkeyAdapter implements Duck {
    private final Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        this.turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.hop();
    }

    @Override
    public void swim() {
        this.turkey.garbageCollect();

    }
}
