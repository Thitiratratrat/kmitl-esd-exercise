package kmitl.esd.exercise2;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class CustomerDTO implements Serializable {
    private long id;
    private String name;
    private int age;
    private String remark;

    public CustomerDTO(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d, Name: %s, Age: %d", id, name, age);
    }
}
