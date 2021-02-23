
package th.kmitl.esd.api;

import kmitl.esd.exercise2.CustomerDTO;
import kmitl.esd.exercise2.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Web service exercise
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService = CustomerService.getInstance();

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);

        return customerDTO;
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        Optional<CustomerDTO> customerToBeUpdated = customerService.getCustomer(customerDTO.getId());

        if (!customerToBeUpdated.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        customerService.updateCustomer(customerDTO);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("findall")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("find/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") Long customerId) {
        Optional<CustomerDTO> customer = customerService.getCustomer(customerId);

        if (!customer.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        Optional<CustomerDTO> customer = customerService.getCustomer(customerId);

        if (!customer.isPresent()) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomer(customer.get());

        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }
}