import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class PalindromeMaker {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();

            int i = 0;
            int j = line.length() - 1;

            String[] letters = line.split("");


            int r = -1;

            while(i < j){
                if (letters[i].equals(letters[j])){
                    i++;
                    j--;
                } else {

                    if (r != -1){
                        r = -1;
                        break;
                    }

                    r = i;
                    i++;
                }
            }

            if (r == -1){
                i = line.length() - 1;
                j = 0;

                while(i > j){
                    if (letters[i].equals(letters[j])){
                        i--;
                        j++;
                    } else {

                        if (r != -1){
                            r = -1;
                            break;
                        }

                        r = i;
                        i--;
                    }
                }
            }

            System.out.println(r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
