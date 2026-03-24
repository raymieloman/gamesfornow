package nl.edsn.ocp.finaling;
public class Hockeyer {
    private final String name; // compile error if NOT FILLED in ALL constructors


    public Hockeyer() {
        this.name = null;
    }


    public String getName() {
        return name;
    }

    public final void play() {

    }
}