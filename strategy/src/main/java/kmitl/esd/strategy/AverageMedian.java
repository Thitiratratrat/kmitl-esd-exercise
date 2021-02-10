package kmitl.esd.strategy;

import java.util.List;
import java.util.stream.Collectors;

public class AverageMedian implements Average {
    @Override
    public Float getAverage(List<Float> values) {
        List<Float> sortedValues = values.stream().sorted().collect(Collectors.toList());
        int medianIndex = values.size() / 2;

        return sortedValues.get(medianIndex);
    }
}
