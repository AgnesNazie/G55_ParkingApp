package se.lexicon.Dao.Sequencer;

public class ReservationIdSequencer {
    private static int counter = 1000; // Starting point for IDs

    public static String nextId() {
        return "RES-" + (++counter); // Increment and return the next ID
    }
}
