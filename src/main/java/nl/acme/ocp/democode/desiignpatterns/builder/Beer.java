package nl.acme.ocp.democode.desiignpatterns.builder;

public class Beer {
    private String taste;
    private double alcoholPercentage;
    private String name;

    public static class BeerBuilder {
        private String taste;
        private double alcoholPercentage;
        private String name;

        public BeerBuilder(String name) {
            this.name = name;
        }

        public BeerBuilder withTaste(String taste) {
            this.taste = taste;

            return this;
        }

        public BeerBuilder withAlcohol(double alcohol) {
            this.alcoholPercentage = alcohol;

            return this;
        }
    }
}
