package se.lexicon.Dao;

import se.lexicon.Model.Reservation;

import java.util.Optional;

public interface ReservationDao {
    void save(Reservation reservation);

    Optional<Reservation> findById(String id);

    void update(Reservation reservation);
}
