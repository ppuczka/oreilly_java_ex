package interface_example;

public class Music {

    static void tune(Playable i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] instruments) {
        for (Playable p : instruments) {
            tune(p);
        }
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Wind(),
                new Brass(),
                new Percussion()
        };
        tuneAll(orchestra);
    }
}
