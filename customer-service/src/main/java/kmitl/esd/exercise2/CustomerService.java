package kmitl.esd.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerService {
    static final CustomerService instance = new CustomerService();
    private List<CustomerDTO> customerDTOS = new ArrayList<>();

    private CustomerService() { };

    static public CustomerService getInstance() {
        return instance;
    }

    public List<CustomerDTO> getCustomers() {
        return customerDTOS;
    }

    public Optional<CustomerDTO> getCustomer(Long id) {
        return customerDTOS.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void addCustomer(CustomerDTO customerDTO) {
        customerDTOS.add(customerDTO);
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        CustomerDTO customerToBeUpdated =
                customerDTOS.stream().filter(c -> c.getId() == customerDTO.getId()).findFirst().get();

        customerDTOS.remove(customerToBeUpdated);
        customerDTOS.add(customerDTO);
    }

    public void deleteCustomer(CustomerDTO customerDTO) {
        CustomerDTO customerToBeDeleted =
                customerDTOS.stream().filter(c -> c.getId() == customerDTO.getId()).findFirst().get();

        customerDTOS.remove(customerToBeDeleted);
    }
}
