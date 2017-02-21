import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class BinarySearch {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = {-1, 0, 2, 4, 21, 21, 24, 29, 33, 55, 63, 71, 90, 100};

        try {
            int input = Integer.valueOf(br.readLine());

            System.out.println(find(numbers, input));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int find(int[] numbers, int input){

        if (numbers.length == 0){
            return -1;
        }

        if (numbers.length == 1){
            return numbers[0];
        }

        return findInRange(numbers, input, 0, numbers.length - 1);
    }

    private static int findInRange(int[] numbers, int input, int start, int end){

        if (start == end){
            return numbers[end] == input ? end : -1;
        }

        int middle = start + (end - start) / 2;

        if (numbers[middle] == input){
            return middle;
        }

        if (input < numbers[middle]){
            return findInRange(numbers, input, start, middle);
        }

        return findInRange(numbers, input, middle + 1, end);
    }
}
