/**
 *
 * @author sourabhmundhada
 *
 * 1000 has 300 count of 2's in it. 2000 has 2*300 count of 2's in it. 3000 has
 * 3*300+1000 counts of 2's in it.
 *
 * Therefore, this logic becomes f(n) = n*(10^(n-1)) where n is number of digit
 * in the given number.
 *
 * Consider, x = number/(10^n) where n is number of digit's in the given number,
 * t = total number of appearance
 *
 *
 * if(x>2) then use x*n*(10^n-1) + 10^n, if(x=2) then use x*n*(10^n-1), if(x<2)
 * then use n*10^(n-1)
 *
 */
public class CountApperanceOfNumber {

    public int getCountOfNumberOfApperanceFromZeroToGivenNumber(int number, int digitToCount) {
        int digitsInNumber = 0;
        int tempHighestNumber = Integer.valueOf(number);
        int totalCount = 0;

        while (tempHighestNumber % 10 != tempHighestNumber) {
            tempHighestNumber = tempHighestNumber / 10;
            digitsInNumber++;
        }

        while (number % 10 != number) {
            if (number / Math.pow(10, digitsInNumber) > (double) digitToCount) {
                if (number / Math.pow(10, digitsInNumber) > (double) digitToCount + 1) {
                    totalCount = totalCount + calculateValue(number, digitsInNumber) + (int) Math.pow(10, digitsInNumber);
                    number = getNewNumber(number, digitsInNumber);
                } else {
                    totalCount = totalCount + calculateValue(number, digitsInNumber);
                    number = getNewNumber(number, digitsInNumber);
                    totalCount = totalCount + number + 1;
                }
            } else if (number / Math.pow(10, digitsInNumber) == (double) digitToCount) {
                totalCount = totalCount + calculateValue(number, digitsInNumber) + 1;
                number = getNewNumber(number, digitsInNumber);

            } else if (number / Math.pow(10, digitsInNumber) < (double) digitToCount) {
                totalCount = totalCount + (int) (digitsInNumber * Math.pow(10, digitsInNumber - 1));
                number = getNewNumber(number, digitsInNumber);

            }
            if (number % 10 == number && number % 10 >= digitToCount) {
                totalCount = totalCount + 1;
            }
            digitsInNumber--;
        }
        return totalCount;
    }

    private int getNewNumber(int number, int digitsInNumber) {
        return (int) (number % Math.pow(10, digitsInNumber));
    }

    private int calculateValue(int number, int digitsInNumber) {
        return (int) ((int) (number / Math.pow(10, digitsInNumber)) * (digitsInNumber * Math.pow(10, digitsInNumber - 1)));
    }

}
