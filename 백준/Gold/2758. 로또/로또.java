import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[11][2001];
        for (int i = 1; i <= 2000; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j <= 2000; j++) {
                if(dp[i - 1][j] != 0){
                    for(int k = j * 2; k <= 2000; k++){
                        dp[i][k] += dp[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long result = 0;

            for (int j = 1; j <= m; j++) {
                result += dp[n][j];
            }
            out.append(result).append("\n");
        }
        System.out.println(out);
    }
}
