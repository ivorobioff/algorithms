import java.util.Arrays;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] input = { 100, 21, 8, 9, 61, 5, 2, 59, 12, 66, 42, 1};

        System.out.println(Arrays.toString(sort(input)));
    }

    private static int[] sort(int[] input){

        for (int i = 1; i < input.length; i ++){

            int j = i - 1;

            while (j > -1 && input[j] > input[j + 1]){
                int t = input[j];
                input[j] = input[j + 1];
                input[j + 1] = t;
                j --;
            }
        }

        return input;
    }
}
