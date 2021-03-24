package kmitl.esd.exercise.service;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.model.Quotation;
import kmitl.esd.exercise.repository.QuotationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuotationService {
    Logger logger = LogManager.getLogger(Quotation.class);

    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    CustomerService customerService;

    /* Get all quotations
      return list of all quotations*/
    public List<Quotation> getAllQuotations() {
        List<Quotation> quotations = new ArrayList<>();
        quotationRepository.findAll().forEach(quotation -> quotations.add(quotation));

        return quotations;

    }

    public List<Quotation> getQuotation(LocalDateTime creationDateTime) {
        List<Quotation> quotations = new ArrayList<>();
        quotationRepository.findAllWithCreationDateTimeAfter(creationDateTime)
                .forEach(quotation -> quotations.add(quotation));

        return quotations;
    }

    public List<Quotation> getQuotationByCustomerId(Long customerId) {
        return quotationRepository.findByCustomerId(customerId);
    }

    public Quotation getQuotationById(Long id) {
        return quotationRepository.findById(id).orElse(null);
    }

    public void saveOrUpdateQuotation(Quotation quotation) {
        if (quotation.getCustomer() == null) {
            return;
        }

        if (quotation.getCustomer().getId() == null) {
            quotationRepository.save(quotation);

            return;
        }

        Customer customer = customerService.getCustomerById(quotation.getCustomer().getId());
        logger.info("customer: " + customer.toString());

        quotationRepository.save(quotation);
    }

    public void deleteQuotation(Long id) {
        quotationRepository.deleteById(id);
    }
}
