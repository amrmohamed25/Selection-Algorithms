import java.util.Random;

public class QuickSelect {
    int RANDOMIZED_PARTITION(int[] A, int p, int r) {
        Random rand = new Random();

        int pivot = rand.nextInt(r - p) + p;
        int temp = A[pivot];
        A[pivot] = A[p];
        A[p] = temp;
        int lastS1 = p;
        int firstUnknown = p + 1;
        while (firstUnknown <= r) {
            if (A[firstUnknown] < A[p]) {
                lastS1 = lastS1 + 1;
                temp = A[firstUnknown];
                A[firstUnknown] = A[lastS1];
                A[lastS1] = temp;
            }
            firstUnknown++;
        }
        temp = A[p];
        A[p] = A[lastS1];
        A[lastS1] = temp;
        return lastS1;
    }

    int RANDOMIZED_SELECT(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        int q = RANDOMIZED_PARTITION(A, p, r);
        int k = q - p + 1;
        if (i == k) {
            return A[q];
        } else if (i < k) {
            return RANDOMIZED_SELECT(A, p, q - 1, i);
        } else {
            return RANDOMIZED_SELECT(A, q + 1, r, i - k);
        }
    }

}
