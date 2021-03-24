package kmitl.esd.exercise.repository;

import kmitl.esd.exercise.model.Quotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface QuotationRepository extends CrudRepository<Quotation, Long> {
    @Query("select q from Quotation q where q.creationDateTime >= :creationDateTime")
    List<Quotation> findAllWithCreationDateTimeAfter(@Param("creationDateTime") LocalDateTime creationDateTime);
    List<Quotation> findByCustomerId(@Param("customerId") Long customerId);
    List<Quotation> findAll();
}
