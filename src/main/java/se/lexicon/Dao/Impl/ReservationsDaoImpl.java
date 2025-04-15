package se.lexicon.Dao.Impl;

import se.lexicon.Dao.ReservationDao;
import se.lexicon.Dao.Sequencer.ReservationIdSequencer;
import se.lexicon.Model.Reservation;

import java.util.ArrayList;
import java.util.Optional;

public class ReservationsDaoImpl implements ReservationDao {
    private ArrayList<Reservation> inMemoryStorage = new ArrayList<>();

    @Override
    public void save(Reservation reservation) {
        reservation.setReservationId(ReservationIdSequencer.nextId());
        inMemoryStorage.add(reservation);
    }

    @Override
    public Optional<Reservation> findById(String id) {
        for (Reservation reservation : inMemoryStorage) {
            if (reservation.getReservationId().equals(id)) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Reservation reservation) {
        Optional<Reservation> existingReservationOpt = findById(reservation.getReservationId());
        if (existingReservationOpt.isPresent()) {
            Reservation existingReservation = existingReservationOpt.get();
            existingReservation.setParkingSpot(reservation.getParkingSpot());
            existingReservation.setCustomer(reservation.getCustomer());
            existingReservation.setStartTime(reservation.getStartTime());
            existingReservation.setEndTime(reservation.getEndTime());
        } else {
            throw new IllegalArgumentException("Reservation not found");
        }
    }
}
