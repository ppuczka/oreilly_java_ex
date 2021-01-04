package interface_example;

public class Percussion implements Instrument, Playable {
    @Override
    public void play(Note n) {
        System.out.println(this + ".play()" + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}
