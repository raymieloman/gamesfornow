package nl.acme.ocp.trywithresources;

public class App {

    public static void main(String[] args) {
        try(Box<? super Object> b = new Box()) {
            System.out.println(b);
            b.add(new Object());
        }
        try (Box<String> letterBox = new Box<>()) {
            letterBox.add("A");
        }
        System.out.println(3);
        Box<? extends Object> b = new Box();


    }
}
