package kmitl.esd.exercise.controller;

import kmitl.esd.exercise.model.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @Test
    public void addCustomer() {
        Customer customerJay = new Customer(Long.valueOf(1), "Jay", LocalDate.parse("2000-02-11"));

        Customer customer = customerController.addCustomer(customerJay);

        assertEquals(customerJay.getId(), customer.getId());
        assertEquals(customerJay.getId(), customer.getId());

        customerController.deleteCustomer(Long.valueOf(1));
    }

    @Test
    public void updateCustomer() {
        Customer customerJohn = new Customer(Long.valueOf(2), "John", LocalDate.parse("2000-02-11"));
        Customer updatedCustomerJohn = new Customer(Long.valueOf(2), "John", LocalDate.parse("2001-02-11"));

        customerController.addCustomer(customerJohn);
        ResponseEntity<Customer> customer = customerController.updateCustomer(updatedCustomerJohn);

        assertEquals(customerJohn.getId(), customer.getBody().getId());
        assertEquals(updatedCustomerJohn.getBirthday(), customer.getBody().getBirthday());

        customerController.deleteCustomer(Long.valueOf(2));
    }

    @Test
    public void getCustomer() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));

        customerController.addCustomer(customerJohn);

        ResponseEntity<Customer> customer = customerController.getCustomer(customerJohn.getId());

        assertEquals(customerJohn.getId(), customer.getBody().getId());

        customerController.deleteCustomer(Long.valueOf(1));
    }

    @Test
    public void getCustomerByName() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));

        customerController.addCustomer(customerJohn);

        List<Customer> customer = customerController.getCustomerByName("John");

        assertEquals(1, customer.size());
        assertEquals("John", customer.get(0).getName());

        customerController.deleteCustomer(Long.valueOf(1));
    }
}