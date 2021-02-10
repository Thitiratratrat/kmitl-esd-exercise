package kmitl.esd.strategy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageMedianTest {
    @Test
    void shouldReturnAverageMedian() {
        List<Float> values = new ArrayList<>();

        values.add(5.0f);
        values.add(1.0f);
        values.add(2.0f);
        values.add(1.0f);
        values.add(0.0f);

        AverageMedian averageMedian = new AverageMedian();
        Float average = averageMedian.getAverage(values);

        assertEquals(1.0f, average);
    }
}