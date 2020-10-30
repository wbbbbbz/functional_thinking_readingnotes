import java.util.*;
import java.util.stream.IntStream;

public class NumberClassifierJava {

    private int target;

    public NumberClassifierJava(int target){
        this.target = target;
    }

    public static IntStream factorOfNumber(int target){
        return IntStream.range(1, target).filter(x -> target % x == 0);
    }

    public static int aliquotSumOfNumber(int target){
        return factorOfNumber(target).sum();
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        int lower = 2;
        int upper = target;
        while (lower < upper){
            if (target % lower == 0){
                upper = target / lower;
                factors.add(lower);
                factors.add(upper);
            }
            lower++;
        }
        return factors;
    }

    public int getTarget(){
        return target;
    }

    public int aliquotSum(){
        int result = 0;
        for(Integer i : getFactors()){
            result += i;
        }
        return result;
    }

    public boolean isPerfect() {
        return aliquotSum() == target;
    }

    public boolean isAbundant() {
        return aliquotSum() > target;
    }

    public boolean isDeficient() {
        return aliquotSum() < target;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            NumberClassifierJava ncj = new NumberClassifierJava(rd.nextInt(10000));
            System.out.println(ncj.getTarget());
            System.out.println(ncj.aliquotSum());
            System.out.println(aliquotSumOfNumber(ncj.getTarget()));
            System.out.println(ncj.getFactors());
            System.out.println(Arrays.toString(factorOfNumber(ncj.getTarget()).toArray()));
        }
    }

}
