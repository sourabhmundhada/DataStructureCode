public class BubbleSort {
    public void sortArray(int[] q) {
        boolean isArraySorted = false;
        do {
            int swapCounter = 0;
            for (int i = 0; i < q.length - 1; i++) {
                if (q[i] > q[i + 1]) {
                    int temp = q[i];
                    q[i] = q[i + 1];
                    q[i + 1] = temp;
                    swapCounter += 1;
                }
            }
            if (swapCounter == 0) {
                isArraySorted = true;
            }
        } while (!isArraySorted);
    }
}
