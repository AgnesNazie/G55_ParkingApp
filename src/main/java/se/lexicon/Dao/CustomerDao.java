package se.lexicon.Dao;

import se.lexicon.Model.Customer;

import java.util.Optional;

public interface CustomerDao {

    Customer save(Customer customer);

    Optional<Customer> findById(Integer id);
}
