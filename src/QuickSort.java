import java.util.Arrays;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = { 52, -1, 82, 4, 0, 72, 53, 100, -3, 82, 99, 52, 33, 21 };

        divide(numbers);

        System.out.println(Arrays.toString(numbers));
    }

    private static int[] divide(int[] numbers) {
        return divide(numbers, 0, numbers.length - 1);
    }


    private static int[] divide(int[] numbers, int start, int pivot) {

        if (start == pivot){
            return numbers;
        }

        int left = start;
        int right = pivot - 1;
        int t;

        while (left < right){

            if (numbers[left] > numbers[pivot] && numbers[right] < numbers[pivot]){
                t = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = t;
                left ++;
                right --;
            } else {
                if (numbers[left] <= numbers[pivot]){
                    left ++;
                }

                if (numbers[right] >= numbers[pivot]){
                    right --;
                }
            }
        }

        if (numbers[left] > numbers[pivot]){
            t = numbers[pivot];
            numbers[pivot] = numbers[left];
            numbers[left] = t;
        }

        divide(numbers, 0, left);
        divide(numbers, left + 1, pivot);

        return  numbers;
    }
}
