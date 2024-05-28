import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[][] matrices;

    static int[][] d;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        matrices = new int[n][];
        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            matrices[i] = new int[]{left, right};
        }

        int result = dp(0, n - 1);
        System.out.println(result);

    }

    public static int dp(int start, int end) {
        if (start == end) return 0;

        if (d[start][end] != 0) return d[start][end];

        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(dp(start, i) + dp(i + 1, end) + matrices[start][0] * matrices[i][1] * matrices[end][1], min);
        }
        d[start][end] = min;

        return d[start][end];
    }

}