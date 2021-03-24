package kmitl.esd.exercise.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.model.Quotation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuotationControllerTest {
    @Autowired
    private QuotationController quotationController;
    private Quotation quotationData;

    @Before
    public void setup() {
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Quotation quotationJohn = new Quotation(Long.valueOf(1), "John's quotation", customerJohn, Float.valueOf(200)
                , LocalDateTime.parse("2021-03-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));

        quotationData = quotationJohn;
    }


    @Test
    public void getAllQuotations() {
        quotationController.addQuotation(quotationData);

        List<Quotation> quotations = quotationController.getAllQuotations();

        assertEquals(1, quotations.size());
        assertEquals(quotationData.getId(), quotations.get(0).getId());

        quotationController.deleteQuotation(quotationData.getId());
    }

    @Test
    public void getQuotation() {
        quotationController.addQuotation(quotationData);

        ResponseEntity<Quotation> quotation = quotationController.getQuotation(quotationData.getId());

        assertEquals(quotationData.getId(), quotation.getBody().getId());

        quotationController.deleteQuotation(quotationData.getId());
    }

    @Test
    public void addQuotation() {
        quotationController.addQuotation(quotationData);

        List<Quotation> quotations = quotationController.getAllQuotations();

        assertEquals(1, quotations.size());
        assertEquals(quotationData.getId(), quotations.get(0).getId());

        quotationController.deleteQuotation(quotationData.getId());
    }

    @Test
    public void updateQuotation() {
        quotationController.addQuotation(quotationData);
        Customer customerJohn = new Customer(Long.valueOf(1), "John", LocalDate.parse("2000-02-11"));
        Quotation updatedQuotation = new Quotation(Long.valueOf(1), "John's updated quotation", customerJohn,
                Float.valueOf(200)
                , LocalDateTime.parse("2021-03-18T10:46"), LocalDateTime.parse("2021-10-23T10:46"));

        ResponseEntity<Quotation> quotation = quotationController.updateQuotation(updatedQuotation);

        assertEquals("John's updated quotation", quotation.getBody().getReference());

        quotationController.deleteQuotation(quotationData.getId());
    }
}