package kmitl.esd.exercise2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    private CustomerService customerService = CustomerService.getInstance();

    @Test
    void getInstance() {
        assertEquals(CustomerService.getInstance(), CustomerService.getInstance());
    }

    @Test
    void getCustomers() {
        CustomerDTO customer = new CustomerDTO(0, "John", 20);
        customerService.addCustomer(customer);

        assertEquals(1, customerService.getCustomers().size());

        customerService.deleteCustomer(customer);
    }

    @Test
    void getCustomer() {
        CustomerDTO customerDTO = new CustomerDTO(0, "John", 20);
        customerService.addCustomer(customerDTO);

        Optional<CustomerDTO> addedCustomerDTO = customerService.getCustomer((long) 0);

        assertNotNull(customerDTO);
        assertEquals(customerDTO, addedCustomerDTO.get());

        customerService.deleteCustomer(customerDTO);
    }

    @Test
    void shoulNotGetCustomerWhenInvalidId() {
        Optional<CustomerDTO> addedCustomerDTO = customerService.getCustomer((long) 0);

        assertFalse(addedCustomerDTO.isPresent());
    }

    @Test
    void addCustomer() {
        CustomerDTO customerDTO = new CustomerDTO(0, "John", 20);
        customerService.addCustomer(customerDTO);

        assertEquals(1, customerService.getCustomers().size());

        customerService.deleteCustomer(customerDTO);
    }

    @Test
    void updateCustomer() {
        CustomerDTO oldCustomerDTO = new CustomerDTO((long)0, "John", 20);
        CustomerDTO newCustomerDTO = new CustomerDTO((long)0, "Jay", 22);

        customerService.addCustomer(oldCustomerDTO);

        customerService.updateCustomer(newCustomerDTO);

        Optional<CustomerDTO> addedCustomerDTO = customerService.getCustomer((long) 0);

        assertEquals(1, customerService.getCustomers().size());
        assertTrue(addedCustomerDTO.isPresent());
        assertEquals(newCustomerDTO, addedCustomerDTO.get());

        customerService.deleteCustomer(newCustomerDTO);
    }

    @Test
    void deleteCustomer() {
        CustomerDTO customerDTO = new CustomerDTO(0, "John", 20);
        CustomerDTO customerDTO2 = new CustomerDTO(1, "Jay", 22);

        customerService.addCustomer(customerDTO);
        customerService.addCustomer(customerDTO2);

        customerService.deleteCustomer(customerDTO);

        List<CustomerDTO> customers = customerService.getCustomers();

        assertEquals(1, customers.size());
        assertEquals(customerDTO2, customers.get(0));

        customerService.deleteCustomer(customerDTO2);
    }
}