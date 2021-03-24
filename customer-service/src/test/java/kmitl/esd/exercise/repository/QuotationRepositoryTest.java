package kmitl.esd.exercise.repository;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.model.Quotation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuotationRepositoryTest {
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private TestEntityManager entityManager;

    private List<Quotation> quotations = new ArrayList<>();

    @Before
    public void setup() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Customer customerAlex = new Customer(Long.valueOf(2), "Alex", LocalDate.parse("2001-10-11"));
        Quotation quotationJohn = new Quotation(Long.valueOf(1), "John's quotation", customerJohn, Float.valueOf(200)
                , LocalDateTime.parse("2021-03-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));
        Quotation quotationAlex = new Quotation(Long.valueOf(2), "Alex's quotation", customerAlex, Float.valueOf(300)
                , LocalDateTime.parse("2021-02-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));

        entityManager.persist(customerJohn);
        entityManager.persist(customerAlex);
        entityManager.persist(quotationJohn);
        entityManager.persist(quotationAlex);
        entityManager.flush();

        quotations.add(quotationJohn);
        quotations.add(quotationAlex);
    }


    @Test
    public void findAllWithCreationDateTimeAfter() {
        LocalDateTime creationDateTime = LocalDateTime.parse("2021-02-19T10:46");

        List<Quotation> quotations = quotationRepository.findAllWithCreationDateTimeAfter(creationDateTime);

        assertEquals(1, quotations.size());
        assertEquals(this.quotations.get(0).getId(), quotations.get(0).getId());
    }

    @Test
    public void findByCustomerId() {
        Long customerId = quotations.get(0).getCustomer().getId();

        List<Quotation> quotations = quotationRepository.findByCustomerId(customerId);

        assertEquals(1, quotations.size());
        assertEquals(customerId, quotations.get(0).getCustomer().getId());
    }

    @Test
    public void findAll() {
        List<Quotation> quotations = quotationRepository.findAll();

        assertEquals(2, quotations.size());
        assertEquals(this.quotations.get(0).getId(), quotations.get(0).getId());
        assertEquals(this.quotations.get(1).getId(), quotations.get(1).getId());
    }
}