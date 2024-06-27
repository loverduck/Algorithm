import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();

    static Integer[][] count = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            Integer[] result = solution(num);
            out.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(out);
    }

    public static Integer[] solution(int num) {
        if (count[num][0] == null) {
            Integer[] a = solution(num - 1);
            Integer[] b = solution(num - 2);
            count[num][0] = a[0] + b[0];
            count[num][1] = a[1] + b[1];
        }
        return count[num];
    }
}
