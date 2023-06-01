package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.Customer;
import ra.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")

public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> list = (List<Customer>) customerService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping("create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer c = customerService.save(customer);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (customerOptional.isPresent()) {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("searchByName/{name}")
    public ResponseEntity<List<Customer>> searchByName(@PathVariable("name") String name) {
        List<Customer> list = (List<Customer>) customerService.searchByName(name);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("searchByAge/{age}")
    public ResponseEntity<List<Customer>> searchByAge(@PathVariable("age") int age){
        List<Customer> list = (List<Customer>) customerService.searchByAge(age);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
