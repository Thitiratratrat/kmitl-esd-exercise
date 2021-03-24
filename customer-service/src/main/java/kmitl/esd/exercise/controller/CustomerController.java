package kmitl.esd.exercise.controller;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customerDTO) {
        Long id = customerDTO.getId();
        customerService.saveOrUpdateCustomer(customerDTO);

        return customerService.getCustomerById(id);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Long id = customer.getId();
        Optional<Customer> customerToBeUpdated =
                Optional.ofNullable(customerService.getCustomerById(customer.getId()));

        if (!customerToBeUpdated.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        customerService.saveOrUpdateCustomer(customer);

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("findall")
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomerById(customerId));

        if (!customer.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @GetMapping("find-name/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name) {
        return customerService.getCustomerByName(name);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomerById(customerId));

        if (!customer.isPresent()) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomer(customer.get().getId());

        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }
}
