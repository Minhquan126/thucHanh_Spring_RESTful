package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Customer;
import ra.dao.ICustomerRepository;

import java.util.Optional;
@Service
public class CustomerServiceIMPL implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }

    @Override
    public Iterable<Customer> searchByAge(int age) {
        return customerRepository.searchByAge(age);
    }
}
