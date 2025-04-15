package se.lexicon.Dao.Sequencer;

public class CustomerIdSequencer {
    private static int sequencer = 1000;

    public static int nextId() {
        return ++sequencer;
    }
}
