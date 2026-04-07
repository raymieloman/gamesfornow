package nl.acme.ocp.democode.designpatterns;

public class Bodem {
    private String type;
    private int size;

    private Bodem(BodemBuilder builder) {
        this.size = builder.size;
        this.type = builder.type;
    }

    public static class BodemBuilder {
        private final String type;
        private int size;

        public BodemBuilder(String type) {
            this.type = type;
        }

        public BodemBuilder withSize(int size) {
            this.size = size;

            return this;
        }

        public Bodem build() {
            return new Bodem(this);
        }
    }
}
