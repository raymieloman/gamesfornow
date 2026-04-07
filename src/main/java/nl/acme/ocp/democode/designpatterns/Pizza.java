package nl.acme.ocp.democode.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private List<String> ingredients;
    private double size;
    private double price;
    private String style;
    private Bodem bodem;

    private Pizza(PizzaBuilder builder) {
        this.ingredients = new ArrayList<>(builder.ingredients);
        this.size = builder.size;
        this.price = builder.price;
        this.style = builder.style;
        this.bodem = builder.bodem;
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
        private Bodem bodem;

        public PizzaBuilder(double price, double size, String style) {
            this.price = price;
            this.size = size;
            this.style = style;
        }

        public PizzaBuilder withIngredient(String ingredient) {
            this.ingredients.add(ingredient);

            return this;
        }

        public PizzaBuilder withBodem(Bodem bodem) {
            
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
