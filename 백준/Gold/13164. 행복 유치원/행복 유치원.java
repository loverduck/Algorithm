import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] student = new int[n];
        int[] diff = new int[n - 1];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(student);

        for (int i = 0; i < n - 1; i++) {
            diff[i] = student[i + 1] - student[i];
        }
        Arrays.sort(diff);

        for(int i = 0; i < n - k; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}
