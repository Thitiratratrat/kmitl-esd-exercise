package kmitl.esd.strategy;

import java.util.List;
import java.util.logging.Logger;

public class UsSensor {
    private static Logger logger = Logger.getLogger(UsSensor.class.getName());
    private Average average;
    private List<Float> values;

    public void setAverage(Average average) {
        this.average = average;
    }

    public void setValues(List<Float> values) {
        this.values = values;
    }

    public void printAverage() {
        logger.info(String.valueOf(average.getAverage(values)));
    }

    public void measure() {
        logger.info(String.valueOf(values));
    }
}
