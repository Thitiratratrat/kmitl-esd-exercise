package kmitl.esd.strategy;

import java.util.List;

/**
 * Interface:
 * a) interface needed when there no implementation of method possible
 * b) internal implementation is not to be shown (hide)
 * c) use-case that needed a specific interface (SOLID)
 * Class:
 * implementation of method possible is desired
 * - abstract class:
 * - concrete class:
 */
public interface Average {
    Float getAverage(List<Float> values);

}
