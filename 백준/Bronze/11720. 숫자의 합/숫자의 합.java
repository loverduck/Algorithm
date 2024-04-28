import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += str.charAt(i) - '0';
        }
        System.out.println(result);
    }

}
