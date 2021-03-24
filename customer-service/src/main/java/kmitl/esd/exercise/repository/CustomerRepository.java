package kmitl.esd.exercise.repository;


import kmitl.esd.exercise.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository  extends CrudRepository<Customer, Long>{
    List<Customer> findByNameOrderByName(String name);

    List<Customer> findByNameOrderByAge(String name);

    List<Customer> findByNameAndAgeOrderById(String name, Integer age);
}
