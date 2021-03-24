package kmitl.esd.exercise.repository;

import kmitl.esd.exercise.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TestEntityManager entityManager;

    private List<Customer> customers = new ArrayList<>();

    @Before
    public void setup() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Customer customerAlex = new Customer(Long.valueOf(2), "Alex", LocalDate.parse("2001-10-11"));

        entityManager.persist(customerJohn);
        entityManager.persist(customerAlex);
        entityManager.flush();

        customers.add(customerJohn);
        customers.add(customerAlex);
    }

    @Test
    public void findByNameOrderByName() {
        String name = "John";
        List<Customer> customers = customerRepository.findByNameOrderByName(name);

        assertEquals(1, customers.size());
        assertEquals(name, customers.get(0).getName());
    }

    @Test
    public void findAll() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();

        assertEquals(2, customers.size());
        assertEquals(this.customers.get(0).getId(), customers.get(0).getId());
        assertEquals(this.customers.get(1).getId(), customers.get(1).getId());
    }

    @Test
    public void findById() {
        Optional<Customer> customer = customerRepository.findById(Long.valueOf(1));

        assertNotNull(customer.get());
        assertEquals(1, customer.get().getId());
    }
}