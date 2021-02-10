package kmitl.esd.strategy;

import java.util.List;

public class AverageMean implements Average {
    @Override
    public Float getAverage(List<Float> values) {
        float sum = 0;

        for (Float value : values) {
            sum += value;
        }

        return sum / values.size();
    }
}
