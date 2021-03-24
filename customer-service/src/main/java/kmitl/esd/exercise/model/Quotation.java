package kmitl.esd.exercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table
@NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q ORDER BY q.customer.id, q.id")
@NamedQuery(name = "Quotation.findByCustomerId", query = "SELECT q FROM Quotation q WHERE q.customer.id = :customerId " +
        "ORDER by q.id")
@NoArgsConstructor
@Getter
@Setter
public class Quotation {
    @Id
    @Column
    private Long id;

    @Column
    @NotNull
    @Size(min = 3, max = 240)
    private String reference;

    @ManyToOne
    @NotNull
    private Customer customer;

    @NotNull
    @Min(0)
    private Float price;

    @Column
    @Past
    private LocalDateTime creationDateTime;

    @Column
    @Future
    private LocalDateTime validUntilDateTime;

    @Column
    private LocalDateTime saveDateTime;

    @PreUpdate
    @PrePersist
    public void setSaveTimeStamp() {
        saveDateTime = LocalDateTime.now();
    }

    public Quotation(Long id, String reference, Customer customer, Float price, LocalDateTime creationDateTime,
                     LocalDateTime validUntilDateTime) {
        this.id = id;
        this.reference = reference;
        this.customer = customer;
        this.price = price;
        this.creationDateTime = creationDateTime;
        this.validUntilDateTime = validUntilDateTime;
    }
}
