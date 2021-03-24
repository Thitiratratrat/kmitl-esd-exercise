package kmitl.esd.exercise.service;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /*   Get all customers and updates their ages*/
    public List<Customer> getCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        customers.forEach(customer -> updateAge(customer));

        return customers;
    }

    /*   Get customers by their names and updates their ages*/
    public List<Customer> getCustomerByName(String name) {
        List<Customer> customers = customerRepository.findByNameOrderByName(name);
        customers.forEach(customer -> updateAge(customer));

        return customers;
    }

    /*   Get customers by their id and updates their ages.
    If customer is not present return null*/
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(updatingCustomer -> updateAge(updatingCustomer));

        return customer.orElse(null);
    }

    /*   Saves the customer passed in as the parameter to the database*/
    public void saveOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /*   deletes the customer by the id passed in as a parameter*/
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    /*  updates the age of the customer which is calculated from the customer's birthday and the current year*/
    private void updateAge(Customer customer) {
        LocalDate now = LocalDate.now();
        customer.setAge(customer.getBirthday().until(now).getYears());
    }
}
