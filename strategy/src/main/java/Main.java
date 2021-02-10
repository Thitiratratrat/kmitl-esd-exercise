import kmitl.esd.strategy.AverageMean;
import kmitl.esd.strategy.AverageMedian;
import kmitl.esd.strategy.UsSensor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Float> values = new ArrayList<>();

        values.add(5.0f);
        values.add(1.3f);
        values.add(2.2f);
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
