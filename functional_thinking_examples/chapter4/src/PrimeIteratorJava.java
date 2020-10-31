import java.util.*;

public class PrimeIteratorJava implements Iterator<Integer> {
    private int lastPrime = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return lastPrime = PrimeJava.nextPrimeFrom(lastPrime);
    }

    @Override
    public void remove() {
        throw new RuntimeException("颠覆宇宙真理的异常！");
    }
}
