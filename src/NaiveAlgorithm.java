import java.util.Arrays;

public class NaiveAlgorithm {
    int naiveAlgorithm(int[] A, int key) {
        Arrays.sort(A);
        return A[key-1];
    }
}
