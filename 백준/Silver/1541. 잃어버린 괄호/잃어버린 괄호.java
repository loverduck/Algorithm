import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split("-");

        int result = 0;
        for (int i = 0; i < str.length; i++) {
            String[] arr = str[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += Integer.parseInt(arr[j]);
            }

            if(i == 0) {
                result += sum;
                continue;
            }
            result -= sum;
        }
        System.out.println(result);
    }


}
