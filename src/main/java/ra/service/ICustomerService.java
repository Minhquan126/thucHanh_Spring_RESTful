package ra.service;

import ra.model.Customer;

public interface ICustomerService extends IGeneric<Customer,Long>{
    Iterable<Customer> searchByName(String name);
    Iterable<Customer> searchByAge(int age);
}
