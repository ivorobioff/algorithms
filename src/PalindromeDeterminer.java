import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class PalindromeDeterminer {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();
            System.out.println(isPalindrome(line) ? "Yes" : "No");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Average performance: O(n)
    private static boolean isPalindrome(String line){

        int i = 0;
        int j = line.length() - 1;

        String[] letters = line.split("");

        while(i < j){

            // as humans, we don't care about case sensitivity, because letters in lower/upper cases are read equally

            if (!letters[i].toLowerCase().equals(letters[j].toLowerCase())){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
