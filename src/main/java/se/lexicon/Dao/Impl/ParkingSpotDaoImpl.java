package se.lexicon.Dao.Impl;


import se.lexicon.Dao.ParkingSpotDao;
import se.lexicon.Dao.Sequencer.ParkingSpotIdSequencer;
import se.lexicon.Model.ParkingSpot;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {

    private ArrayList<ParkingSpot> inMemoryStorage = new ArrayList<>();

    @Override
    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpot.setId(ParkingSpotIdSequencer.nextId());
        inMemoryStorage.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public ArrayList<ParkingSpot> findAll() {
        return new ArrayList<>(inMemoryStorage);
    }

    @Override
    public ArrayList<ParkingSpot> findAllAvailableSpots() {
        ArrayList<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : inMemoryStorage) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

    @Override
    public Optional<ParkingSpot> findById(Integer id) {
        for (ParkingSpot spot : inMemoryStorage) {
            if (spot.getId().equals(id)) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(ParkingSpot parkingSpot) {
        for (int i = 0; i < inMemoryStorage.size(); i++) {
            if (inMemoryStorage.get(i).getId().equals(parkingSpot.getId())) {
                inMemoryStorage.set(i, parkingSpot);
                return;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        inMemoryStorage.removeIf(spot -> spot.getId().equals(id));
    }
}

