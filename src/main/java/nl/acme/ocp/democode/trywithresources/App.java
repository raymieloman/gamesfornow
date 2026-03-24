package nl.acme.ocp.democode.trywithresources;

public class App {

    public static void main(String[] args) {
        try(Box<Integer> b = new Box()) {
            System.out.println(b);
            b.add(3);
        }
        try (Box<String> letterBox = new Box<>()) {
            letterBox.add("A");
        }
    }
}
