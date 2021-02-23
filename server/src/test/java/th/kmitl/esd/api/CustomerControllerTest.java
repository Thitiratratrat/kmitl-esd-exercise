package th.kmitl.esd.api;

import kmitl.esd.exercise2.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerControllerTest {
    private CustomerController customerController = new CustomerController();

    @Test
    void addCustomer() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);

        CustomerDTO addedCustomer = customerController.addCustomer(customer);

        assertEquals(customer, addedCustomer);

        customerController.deleteCustomer((long)0);

        System.out.println(customerController.getAllCustomers().size());
    }

    @Test
    void updateCustomerWhenIdIsPresent() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);
        CustomerDTO newCustomer = new CustomerDTO(0,"Jay", 22);

        customerController.addCustomer(customer);

        ResponseEntity<CustomerDTO> updatedCustomer = customerController.updateCustomer(newCustomer);

        assertEquals(HttpStatus.OK, updatedCustomer.getStatusCode());
        assertEquals(customer.getId(), updatedCustomer.getBody().getId());

        customerController.deleteCustomer((long) 0);
    }

    @Test
    void returnNotFoundWhenUpdateCustomerIdIsNotPresent() {
        CustomerDTO newCustomer = new CustomerDTO(0, "Jay", 22);


        ResponseEntity<CustomerDTO> response = customerController.updateCustomer(newCustomer);

        assertNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        customerController.deleteCustomer((long) 0);
    }

    @Test
    void getAllCustomers() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);
        CustomerDTO customer2 = new CustomerDTO(1, "Jay", 22);

        customerController.addCustomer(customer);
        customerController.addCustomer(customer2);

        List<CustomerDTO> customers = customerController.getAllCustomers();

        assertEquals(2, customers.size());

        customerController.deleteCustomer((long) 0);
        customerController.deleteCustomer((long) 1);
    }

    @Test
    void getCustomer() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);
        customerController.addCustomer(customer);

        ResponseEntity<CustomerDTO> response = customerController.getCustomer((long) 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().getId());

        customerController.deleteCustomer((long) 0);
    }

    @Test
    void deleteCustomer() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);
        customerController.addCustomer(customer);

        ResponseEntity<String> response = customerController.deleteCustomer((long) 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}