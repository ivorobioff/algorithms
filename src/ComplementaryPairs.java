import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class ComplementaryPairs {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();

            int[] numbers = { 3, 12, -2, 42, 18, 6, 12, 7, -9, 0, 4, 31 };

            List<Integer[]> pairs = getComplementaryPairs(Integer.valueOf(line), numbers);

            if (pairs.isEmpty()){
                System.out.println("No complementary pairs!");
            } else {
                for (Integer[] pair : pairs){
                    System.out.printf("%s with %s are complementary pairs!\n", pair[0], pair[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The algorithm works as following:
     *
     * First, we sort the array applying the "quicksort" algorithm, so that the numbers go from lowest to highest.
     * Second, we take one by one the lowest numbers and respective highest numbers from both ends, and compare their sum with "k".
     * If the sum is equal then we peek that pair.
     * If the sum is greater than "k" then we take the next highest number.
     * If the sum is less than "k" we take the next lowest number.
     *
     * Average performance: O(n * log n)
     */
    private static List<Integer[]> getComplementaryPairs(int k, int[] numbers)
    {
        // It implements the "quicksort" algorithm because we use an array of primitive values.
        // This is more efficient in terms of memory usage than the "mergesort" algorithm.

        Arrays.sort(numbers);

        int i = 0;
        int j = numbers.length - 1;
        List<Integer[]> pairs = new ArrayList<>();

        while (i < j){
            int small = numbers[i];
            int large = numbers[j];
            int sum = small + large;

            if (sum == k){
                pairs.add(new Integer[]{small, large});
                i ++;
                j --;
            } else if (sum > k){
                j --;
            } else {
                i ++;
            }
        }

        return pairs;
    }
}
