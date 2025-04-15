package se.lexicon.Dao;

import se.lexicon.Model.ParkingSpot;

import java.util.ArrayList;
import java.util.Optional;

public interface ParkingSpotDao {
    ParkingSpot save(ParkingSpot parkingSpot);

    ArrayList<ParkingSpot> findAll();

    ArrayList<ParkingSpot> findAllAvailableSpots();

    Optional<ParkingSpot> findById(Integer id);

    void update(ParkingSpot parkingSpot);

    void delete(Integer id);
}
