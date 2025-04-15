package se.lexicon.Model;

public class ParkingSpot {
    //fields
    private Integer spotNumber;
    private Integer areaCode;
    private boolean occupied;

    //constructor

    public ParkingSpot(Integer spotNumber, Integer areaCode) {
        this.spotNumber = spotNumber;
        this.areaCode = areaCode;
    }
    //getter for spot number

    public Integer getSpotNumber() {
        return spotNumber;
    }
    // setter for spot number

    public void setSpotNumber(Integer spotNumber) {
        if (spotNumber == null)
            throw new IllegalArgumentException("Spot number cannot be null");
        this.spotNumber = spotNumber;
    }
    //getter for area code

    public Integer getAreaCode() {
        return areaCode;
    }
    //setter for area code

    public void setAreaCode(Integer areaCode) {
        if (areaCode == null)
            throw new IllegalArgumentException("Area Code cannot be null");
        this.areaCode = areaCode;
    }
    //getter for is occupied

    public boolean isOccupied() {
        return occupied;
    }
    //method to check parking spot is available


    public void occupy() {
        if (occupied) {
            throw new IllegalArgumentException("Parking spot is already occupied");
        }
        this.occupied = true;

    }
    //method to check parking spot is vacate

    public void vacate() {
        if (!occupied) {
            throw new IllegalArgumentException("Parking spot is already vacant");
        }
        this.occupied = false;
    }

}
