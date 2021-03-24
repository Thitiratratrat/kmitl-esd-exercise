package kmitl.esd.exercise.service;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private List<Customer> customers;

    @Before
    public void init() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Customer customerAlex = new Customer(Long.valueOf(2), "Alex", LocalDate.parse("2001-10-11"));

        customers = List.of(customerJohn, customerAlex);
    }

    @Test
    public void getCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> customers = customerService.getCustomers();

        assertEquals(2, customers.size());
        assertEquals(21, customers.get(0).getAge());
        assertEquals(19, customers.get(1).getAge());
    }

    @Test
    public void getCustomerByName() {
        String name = "John";

        when(customerRepository.findByNameOrderByName(name)).thenReturn(List.of(customers.get(0)));

        List<Customer> customers = customerService.getCustomerByName(name);

        assertEquals(1, customers.size());
        assertEquals(name, customers.get(0).getName());
    }

    @Test
    public void getCustomerById() {
        Long id = Long.valueOf(2);

        when(customerRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(customers.get(1)));

        Customer customer = customerService.getCustomerById(id);

        assertEquals(id, customer.getId());
    }
}