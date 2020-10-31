import java.util.*;

public class PrimeJava {

    public static boolean isFactor(final int potential, final int number) {
        return number % potential == 0;
    }

    public static Set<Integer> getFactors(final int number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < Math.sqrt(number) + 1; i++) {
            if (isFactor(i, number)){
                set.add(i);
                set.add(number / i);
            }
        }
        return set;
    }

    public static int sumFactors(final int number) {
        int result = 0;
        for (Integer i : getFactors(number)) {
            result += i;
        }
        return result;
    }

    public static boolean isPrime(final int number) {
        return getFactors(number).size() == 2;
    }

    public static Integer nextPrimeFrom(final int lastPrime) {
        int number = lastPrime + 1;
        while (!isPrime(number)) number++;
        return number;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            if(isPrime(i)) System.out.print(i + ", ");
        }

        System.out.println();

        for (PrimeIteratorJava it = new PrimeIteratorJava(); it.hasNext(); ) {
            int i = it.next();
            if (i >= 1000) break;
            System.out.print(i + ", ");
        }
    }
}
