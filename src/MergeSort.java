import java.util.Arrays;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] input = { 100, 21, 8, 9, 61, 5, 2, 59, 12, 66, 42, 1};

        System.out.println(Arrays.toString(sort(input)));
    }

    private static int[] sort(int[] input){

        int l = input.length;

        if (l < 2){
            return input;
        }

        int al = (int) Math.ceil((float)input.length / 2);

        int[] a = Arrays.copyOfRange(input, 0, al);
        int[] b = Arrays.copyOfRange(input, al, l);

        a = sort(a);
        b = sort(b);

        return merge(a, b);
    }

    private static int[] merge(int[] a, int[] b){

        int al = a.length;
        int bl = b.length;
        int l = al + bl;

        int[] result = new int[l];

        int ac = 0;
        int bc = 0;
        int c = 0;

        while (c < l){
            if (ac >= al){
                result[c] = b[bc];
                bc ++;
            } else if (bc >= bl){
                result[c] = a[ac];
                ac ++;
            } else if (a[ac] <= b[bc]){
                result[c] = a[ac];
                ac ++;
            } else {
                result[c] = b[bc];
                bc ++;
            }

            c ++;
        }

        return result;
    }
}
