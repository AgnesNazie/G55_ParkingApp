package se.lexicon.Dao.Impl;

import se.lexicon.Dao.CustomerDao;
import se.lexicon.Dao.Sequencer.CustomerIdSequencer;
import se.lexicon.Model.Customer;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private ArrayList<Customer> inMemoryStorage = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        customer.setId(CustomerIdSequencer.nextId()); // 1001
        inMemoryStorage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        for (Customer customer : inMemoryStorage){
            if (customer.getId().equals(id)){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
}

