import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] arr;
    static int n;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        boolean isZero = false;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 50) isZero = true;
        }

        if (isZero) {
            System.out.println(0);
            return;
        }

        permutation(0, new int[n], new boolean[n]);
        System.out.println(result);
    }

    public static void permutation(int idx, int[] choice, boolean[] selected) {
        if (idx == n) {
            solution(choice);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;

            choice[idx] = arr[i];
            selected[i] = true;
            permutation(idx + 1, choice, selected);
            selected[i] = false;
        }
    }

    public static void solution(int[] perArr) {
        boolean[] point = new boolean[101];
        int line = 0;

        int sum = 0;
        point[0] = true;
        for (int i = 0; i < perArr.length; i++) {
            sum += perArr[i];
            point[sum] = true;
        }

        for (int i = 0; i < 50; i++) {
            if (point[i] && point[i + 50]) line++;
        }

        result = Math.max(result, line);
    }
}
