import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int result = 0;
        char prev = ' ';

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char person = br.readLine().charAt(0);
            if (person == prev) continue;
            prev = person;
            result += 1;
        }

        System.out.println(result + 1);
    }
}
