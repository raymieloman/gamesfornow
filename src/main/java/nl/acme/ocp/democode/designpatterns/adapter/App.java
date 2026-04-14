package nl.acme.ocp.democode.designpatterns.adapter;

public class App {
    public static void main(String[] args) {
        Duck d = new MallardDuck();
        makeNoise(d);

        // This is the demo of the adapter pattern
        Turkey turkey = new Turkey();
        Duck myDuck = new TurkeyAdapter(turkey);
        makeNoise(myDuck);
    }


    public static void makeNoise(Duck duck) {
        duck.quack();
    }
}
