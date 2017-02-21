import java.util.Arrays;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = { 52, -1, 82, 4, 0, 72, 53, 100, -3, 82, 99, 52, 33, 21 };

        numbers = sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    private static int[] sort(int[] numbers) {

        boolean done = false;

        while (!done) {

            done = true;

            for (int i = 1; i < numbers.length; i ++){
                int j = i - 1;

                if (numbers[j] > numbers[i]){
                    int t = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = t;

                    done = false;
                }
            }
        }

        return  numbers;
    }
}
