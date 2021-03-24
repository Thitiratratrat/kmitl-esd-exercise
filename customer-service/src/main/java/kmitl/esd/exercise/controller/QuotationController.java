package kmitl.esd.exercise.controller;

import kmitl.esd.exercise.model.Quotation;
import kmitl.esd.exercise.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quotation")
public class QuotationController {
    @Autowired
    QuotationService quotationService;

    @GetMapping("findall")
    public List<Quotation> getAllQuotations() {
        return quotationService.getAllQuotations();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Quotation> getQuotation(@PathVariable("id") Long id) {
        Optional<Quotation> quotation = Optional.ofNullable(quotationService.getQuotationById(id));

        if (!quotation.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(quotation.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuotation(@PathVariable("id") Long id) {
        Optional<Quotation> quotation = Optional.ofNullable(quotationService.getQuotationById(id));

        if (!quotation.isPresent()) {
            return new ResponseEntity<>("Quotation not found", HttpStatus.NOT_FOUND);
        }

        quotationService.deleteQuotation(quotation.get().getId());

        return new ResponseEntity<>("Quotation deleted", HttpStatus.OK);
    }

    @PostMapping
    public Long addQuotation(@RequestBody Quotation quotation) {
        quotationService.saveOrUpdateQuotation(quotation);

        return quotation.getId();
    }

    @PutMapping
    public ResponseEntity<Quotation> updateQuotation(@RequestBody Quotation quotation) {
        Long id = quotation.getId();
        Optional<Quotation> customerToBeUpdated =
                Optional.ofNullable(quotationService.getQuotationById(quotation.getId()));

        if (!customerToBeUpdated.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        quotationService.saveOrUpdateQuotation(quotation);

        return new ResponseEntity<>(quotationService.getQuotationById(id), HttpStatus.OK);
    }
}
