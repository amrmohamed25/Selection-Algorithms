import java.util.Arrays;
//reference :https://github.com/email4rohit/interview-java-algo/blob/master/MedianOfMedians.java
//reference :https://www.ics.uci.edu/~eppstein/161/960130.html
public class MedianOfMedians {
    int findIndexOfPivot(int[] A, int first, int last, int pivot) {
        while (first < last) {
            while (A[first] < pivot) {//bnmshy mn awl l7d ma pivot yb2a as8r mn A[first]
                first++;
            }
            while (A[last] > pivot) {//bnmshy mn a5r l7d ma pivot yb2a akbr mn A[last]
                last--;
            }
            if (A[first] == A[last]) {//stopping condition
                last--;
            }
            else if (first < last) {//lw first < last hbdl l element l kan sbb en while loop l fo2 tbooz w agrb tany
                int test = A[first];
                A[first] = A[last];
                A[last] = test;
            }
        }
        return first;

    }

    int medianOfMedians(int[] A, int first, int last, int key) {
        if (last - first <= 5) {
            Arrays.sort(A, first, last);
            return A[first + key - 1];
        }

        int pivot = partition(A, first, last);
        int l = findIndexOfPivot(A, first, last, pivot);
        int length = l - first + 1;

        // If mth element is the median, return it
        if (length == key) {
            return A[l];
        }

        // If mth element is greater than median, search in the left subarray
        if (length > key) {
            return medianOfMedians(A, first, l - 1, key);
        }
        // otherwise search in the right subArray
        else {
            return medianOfMedians(A, l + 1, last, key - length);
        }
    }


    int partition(int[] A, int first, int last) {
        int[] S = new int[(last - first) / 5];
        int index = 0;
        int i = first;
        while (i + 5 <= last) {
            Arrays.sort(A, i, i + 5);
            S[index++] = A[i + 2];
            i += 5;
        }
        return medianOfMedians(S, 0, S.length - 1, S.length / 2 + 1);
    }

}
