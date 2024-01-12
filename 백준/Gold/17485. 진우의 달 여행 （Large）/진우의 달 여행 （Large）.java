import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
        
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, result = Integer.MAX_VALUE;
    static int[][] space;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        space = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0) {
                    dp[i][j][0] = space[i][j];
                    dp[i][j][1] = space[i][j];
                    dp[i][j][2] = space[i][j];
                } else if (j == m - 1) {
                    dp[i][j][0] = Integer.MAX_VALUE;
                } else if (j == 0) {
                    dp[i][j][2] = Integer.MAX_VALUE;
                }

            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid(i - 1, j - 1))
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + space[i][j];
                if (isValid(i - 1, j))
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + space[i][j];
                if (isValid(i - 1, j + 1))
                    dp[i][j][0] = Math.min(dp[i -1][j+1][1], dp[i-1][j+1][2]) + space[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                if (result > dp[n - 1][j][k])
                    result = dp[n - 1][j][k];
            }
        }

        System.out.println(result);
    }

    static boolean isValid(int y, int x) {
        return (0 <= y && y < n) &&
                (0 <= x && x < m);
    }
}