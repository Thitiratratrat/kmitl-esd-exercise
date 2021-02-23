package kmitl.esd.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {
    private CustomerDTO customerDTO = new CustomerDTO(0, "John", 20);

    @Test
    void testToString() {
        assertEquals(String.format("Customer ID: %d, Name: %s, Age: %d", 0, "John", 20), customerDTO.toString());
    }
}