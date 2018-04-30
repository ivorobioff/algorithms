/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class BinarySearchNearest {

    public static void main(String[] args) {

        int[] numbers = {1, 4, 12, 19, 23, 30};

        System.out.println(numbers[findInRange(numbers, 2, 0, numbers.length - 1)]);
    }

    private static int findInRange(int[] numbers, int input, int start, int end){

        if ((end - start) == 1) {

            if ((input - numbers[start]) <= (numbers[end] - input)) {
                return start;
            } else {
                return end;
            }
        } else if (end == start) {
            return end;
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
