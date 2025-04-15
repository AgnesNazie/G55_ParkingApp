package se.lexicon.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    //fields
    private Integer id;
    private String name;
    private String phoneNumber;
    private String vehiclePlateNumber;

    //constructor

    public Customer(Integer id, String name, String phoneNumber, String vehiclePlateNumber) {
        setId(id);
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehiclePlateNumber(vehiclePlateNumber);
    }

    public Customer(String name, String phoneNumber, String vehiclePlateNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setVehiclePlateNumber(vehiclePlateNumber);
    }
    //getter for id

    public Integer getId() {
        return id;
    }
    //setter for id

    public void setId(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id should no be null.");
        this.id = id;
    }
    //getter for name

    public String getName() {
        return name;
    }
    //setter for name

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }
    //getter for phone number

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //setter for phone number

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty())
            throw new IllegalArgumentException("Phone Number cannot be null or empty");

        final String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) throw new IllegalArgumentException("Invalid Phone Number");

        this.phoneNumber = phoneNumber;
    }
    //getter for vehicle plate number

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }
    //setter for vehicle plate number

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        if (vehiclePlateNumber == null || vehiclePlateNumber.trim().isEmpty())
            throw new IllegalArgumentException("Vehicle Plate Number cannot be null or empty");

        String normalizedPlate = vehiclePlateNumber.trim().toUpperCase();
        final String regex = "^[A-HJ-NPR-UW-Z]{3}\\s\\d{2}[A-HJ-NPR-UW-Z0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(normalizedPlate);
        if (!matcher.matches()) throw new IllegalArgumentException("Invalid License Plate");

        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                '}';
    }
}
