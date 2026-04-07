package nl.acme.ocp.democode.designpatterns;

public class App {
    public static void main(String[] args) {
        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder(7.00, 30, "English");
        builder.withIngredient("Tomatoes");
        builder.withIngredient("Onions");
        builder.withIngredient("Mozarella");
        Pizza p = builder.build();
        System.out.println(p.getSize());
        System.out.println(p.getPrice());
        System.out.println(p.getIngredients());

        Pizza vincent = builder.build();
        Pizza raymond = builder.build();

        Pizza p2 = builder.withIngredient("Kaviaar").withStyle("French").build();

        System.out.println(p2.getIngredients());
        System.out.println(p.getIngredients());

        System.out.println(p);
        System.out.println(p2);

        Pizza p = new Pizza();
    }
}
