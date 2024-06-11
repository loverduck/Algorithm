import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int quarter = 0;
        int half = 0;
        int threeQuarter = 0;

        for (int i = 0; i < n; i++) {
            String piece = br.readLine();
            if (piece.equals("1/4")) quarter++;
            else if (piece.equals("1/2")) half++;
            else threeQuarter++;
        }
        
        int result = 0;
        if (quarter > threeQuarter) quarter -= threeQuarter;
        else quarter = 0;
        result += threeQuarter;

        half += quarter / 2;
        if (quarter % 2 != 0) half++;

        result += half / 2;
        if (half % 2 != 0) result++;

        System.out.println(result);
    }
}
