import java.util.Arrays;
import java.util.Random;

public class selectionMain {

    public static void main(String[] args) {
        Random rand = new Random();
        QuickSelect quickSelect = new QuickSelect();
        MedianOfMedians medianOfMed = new MedianOfMedians();
        NaiveAlgorithm naive = new NaiveAlgorithm();
        int randomSampleRuns = rand.nextInt(5) + 10;
        int j=1;
        System.out.println("Number of Sample runs:"+randomSampleRuns);
        int temp = randomSampleRuns;
        long totalTimeQuickSelect=0;
        long totalTimeMedianOfMedians=0;
        long totalTimeNaiveAlgorithm=0;
        while (temp!=0) {
            System.out.println("Sample run #"+j++);
            int randomArraySize = rand.nextInt(100000000)%100000000;
            int median;

            int arr[] = new int[randomArraySize];
            for (int i = 0; i < randomArraySize; i++) {
                arr[i] = rand.nextInt(10000000);
            }

            long start = System.nanoTime();
            median = quickSelect.RANDOMIZED_SELECT(arr, 0, arr.length - 1, arr.length / 2);
            long end = System.nanoTime();
            System.out.println("//Quick Select Algorithm");
            System.out.println(median);
            System.out.println(end - start);
            System.out.println();
            totalTimeQuickSelect+=end-start;

            //Method two:Median of medians
            start = System.nanoTime();
            median = medianOfMed.medianOfMedians(arr, 0, arr.length - 1, arr.length / 2);
            end = System.nanoTime();
            System.out.println("//Median of Medians Algorithm");
            System.out.println(median);
            System.out.println(end - start);
            System.out.println();
            totalTimeMedianOfMedians+=end-start;


            //Method three:Naive algorithm
            int[] copy = arr.clone();
            start = System.nanoTime();
            median = naive.naiveAlgorithm(copy, copy.length / 2);
            end = System.nanoTime();
            System.out.println("//Naive Algorithm");
            System.out.println(median);
            System.out.println(end - start);
            System.out.println();
            totalTimeNaiveAlgorithm+=end-start;
            temp--;
            System.out.println("-------------------------------------------------");
        }
        long averageTimeQuickSelect=totalTimeQuickSelect/randomSampleRuns;
        long averageTimeMedianOfMedians=totalTimeMedianOfMedians/randomSampleRuns;
        long averageTimeNaiveAlgorithm=totalTimeNaiveAlgorithm/randomSampleRuns;
        System.out.println("\nAverage time of Quick Select:     "+averageTimeQuickSelect);
        System.out.println("Average time of Median of Medians:"+averageTimeMedianOfMedians);
        System.out.println("Average time of Naive Algorithm:  "+averageTimeNaiveAlgorithm);
    }
}
