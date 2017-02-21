import java.util.Arrays;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = { 52, -1, 82, 4, 0, 72, 53, 100, -3, 82, 99, 52, 33, 21 };

        numbers = sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    static private int[] sort(int[] numbers){

        for (int i = 0; i < numbers.length; i ++){

            for (int j = i + 1; j < numbers.length; j ++){
                if (numbers[j] < numbers[i]){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }

        return numbers;
    }
}
