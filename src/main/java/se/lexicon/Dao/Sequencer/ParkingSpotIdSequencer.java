package se.lexicon.Dao.Sequencer;

public class ParkingSpotIdSequencer {
    private static int currentId = 1000;

    public static int nextId() {
        return ++currentId;
    }

    public static void reset() {
        currentId = 1000;
    }
}
