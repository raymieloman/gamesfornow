package nl.acme.ocp.democode.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> ingredients;
    private double size;
    private double price;
    private String style;

    private Pizza(PizzaBuilder builder) {
        this.ingredients = new ArrayList<>(builder.ingredients);
        this.size = builder.size;
        this.price = builder.price;
        this.style = builder.style;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                ", size=" + size +
                ", price=" + price +
                ", style='" + style + '\'' +
                '}';
    }

    public static class PizzaBuilder {

        private double price;
        private double size;
        private String style;
        private final List<String> ingredients = new ArrayList<>();

        public PizzaBuilder(double price, double size, String style) {
            this.price = price;
            this.size = size;
            this.style = style;
        }

        public PizzaBuilder withIngredient(String ingredient) {
            this.ingredients.add(ingredient);

            return this;
        }

        public PizzaBuilder withStyle(String style) {
            this.style = style;

            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
