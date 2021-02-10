package kmitl.esd.strategy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageMeanTest {
    @Test
    void shouldReturnAverageMean() {
        List<Float> values = new ArrayList<>();

        values.add(5.0f);
        values.add(1.0f);
        values.add(2.0f);
        values.add(1.0f);
        values.add(0.0f);

        AverageMean averageMean = new AverageMean();
        Float average = averageMean.getAverage(values);

        assertEquals(1.8f, average);
    }
}