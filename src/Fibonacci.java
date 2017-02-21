import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Igor Vorobiov <igor.vorobioff@gmail.com>
 */
public class Fibonacci {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(getValueByOrder(Integer.valueOf(br.readLine())));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getValueByOrder(int o)
    {
        if (o == 0){
            return 0;
        }

        int f = 0;
        int s = 1;
        int r = f + s;

        for (int i = 2; i <= o; i ++){
            r = f + s;
            f = s;
            s = r;
        }

        return r;
    }
}
