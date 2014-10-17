import java.util.SortedSet;
import java.util.TreeSet;
/**
 *
 * @author sourabhmundhada
 */
public class ListCommanMultiple {

    PrimeNumber prime = new PrimeNumber();

    public int getLCMofGivenNumber(int x, int y) {
        SortedSet<Integer> primeNumbers = new TreeSet<>();
//        Map<Integer, Integer> primeNumberOccured = new HashMap<>();
        int LCMofTwoNumber = 1;
        if (x > y) {
            primeNumbers = prime.getPrimeNumberList((int) x);
        } else {
            primeNumbers = prime.getPrimeNumberList((int) y);
        }

        for (Integer primeNumber : primeNumbers) {
//            int i = 0;
            while (x % primeNumber == 0 || y % primeNumber == 0) {
                if (x % primeNumber == 0 && y % primeNumber == 0) {
                    x = x / primeNumber;
                    y = y / primeNumber;
                    LCMofTwoNumber = primeNumber * LCMofTwoNumber;
//                    primeNumberOccured.put(primeNumber, i++);
                } else if (x % primeNumber == 0) {
                    x = x / primeNumber;
                    LCMofTwoNumber = primeNumber * LCMofTwoNumber;
//                    primeNumberOccured.put(primeNumber, i++);
                } else if (y % primeNumber == 0) {
                    y = y / primeNumber;
                    LCMofTwoNumber = primeNumber * LCMofTwoNumber;
//                    primeNumberOccured.put(primeNumber, i++);
                }
            }
        }

        return LCMofTwoNumber;
    }

}
