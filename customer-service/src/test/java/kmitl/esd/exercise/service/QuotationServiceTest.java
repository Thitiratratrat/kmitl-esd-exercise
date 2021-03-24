package kmitl.esd.exercise.service;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.model.Quotation;
import kmitl.esd.exercise.repository.QuotationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuotationServiceTest {
    private List<Quotation> quotations;
    @Mock
    QuotationRepository quotationRepository;

    @InjectMocks
    private QuotationService quotationService;

    @Before
    public void init() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Customer customerAlex = new Customer(Long.valueOf(2), "Alex", LocalDate.parse("2000-10-11"));
        Quotation quotationJohn = new Quotation(Long.valueOf(1), "John's quotation", customerJohn, Float.valueOf(200)
                , LocalDateTime.parse("2021-03-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));
        Quotation quotationAlex = new Quotation(Long.valueOf(2), "Alex's quotation", customerAlex, Float.valueOf(300)
                , LocalDateTime.parse("2021-04-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));
        quotations = List.of(quotationJohn, quotationAlex);
    }


    @Test
    public void getAllQuotations() {
        when(quotationRepository.findAll()).thenReturn(quotations);

        List<Quotation> quotations = quotationService.getAllQuotations();

        assertEquals(2, quotations.size());
    }

    @Test
    public void getQuotation() {
        LocalDateTime creationDateTime = LocalDateTime.parse("2021-03-19T10:46");

        when(quotationRepository.findAllWithCreationDateTimeAfter(creationDateTime))
                .thenReturn(List.of(quotations.get(1)));

        List<Quotation> quotations = quotationService.getQuotation(creationDateTime);

        assertEquals(1, quotations.size());
    }

    @Test
    public void getQuotationByCustomerId() {
        Long customerId = quotations.get(0).getCustomer().getId();

        when(quotationRepository.findByCustomerId(customerId)).thenReturn(List.of(quotations.get(0)));

        List<Quotation> quotations = quotationService.getQuotationByCustomerId(customerId);

        assertEquals(1, quotations.size());
        assertEquals(customerId, quotations.get(0).getCustomer().getId());
    }

    @Test
    public void getQuotationById() {
        Long quotationId = quotations.get(0).getId();

        when(quotationRepository.findById(quotationId)).thenReturn(java.util.Optional.ofNullable(quotations.get(0)));

        Quotation quotation = quotationService.getQuotationById(quotationId);

        assertEquals(quotationId, quotation.getId());
    }
}