package kmitl.esd.strategy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsSensorTest {
    @Test
    void shouldReturnAverage() {
        List<Float> values = new ArrayList<>();

        values.add(5.0f);
        values.add(1.0f);
        values.add(2.0f);
        values.add(1.0f);
        values.add(0.0f);

        UsSensor usSensor = new UsSensor();
        usSensor.setValues(values);
        usSensor.setAverage(new AverageMean());
        usSensor.printAverage();
        usSensor.setAverage(new AverageMedian());
        usSensor.printAverage();
    }

}