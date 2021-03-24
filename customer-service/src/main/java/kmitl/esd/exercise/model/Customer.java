package kmitl.esd.exercise.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id @Column
    private Long id;

    @Column @NotNull @Size(min=3, max=248)
    private String name;

    @Transient
    private String tempRemark;

    @Column @Min(18) @Max(128)
    private Integer age;

    @Column @Past @NotNull
    private LocalDate birthday;

    @Column @Pattern(regexp="\\(?\\d{0,3}\\)?\\d{3}-\\d{4}")
    private String phoneNumber;

    @Column @Pattern(regexp="\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    private String email;

    @Column @Past
    private LocalDateTime creationDateTime;

    public Customer(Long id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
