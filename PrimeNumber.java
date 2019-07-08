
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
*
* @author sourabhmundhada
*/

public class PrimeNumber {

    public SortedSet<Integer> getPrimeNumberList(int x) {
        int primeNumber = 2;
        SortedSet<Integer> listNumber = new ConcurrentSkipListSet<>();

        for (int i = 2; i <= x; i++) {
            listNumber.add(i);
        }
        while (primeNumber <= x) {
            for (Integer j : listNumber) {
                if (j % primeNumber == 0 && primeNumber != j) {
                    listNumber.remove(j);
                }
            }
            primeNumber += 1;
        }
        return listNumber;

    }

    public boolean isPrime(int checkValue) {
        if (checkValue <= 1) {
            return Boolean.FALSE;
        }
        for (int i = 2; i < Math.sqrt(checkValue); i++) {
            if (checkValue % i == 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
