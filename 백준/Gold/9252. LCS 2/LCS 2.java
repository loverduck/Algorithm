import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[][] dp = new int[str2.length + 1][str1.length + 1];
        for (int i = 1; i <= str2.length; i++) {
            for (int j = 1; j <= str1.length; j++) {
                if(str2[i - 1] == str1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int result = dp[str2.length][str1.length];
        int i = str1.length;
        while (result > 0) {
            for (int j = str2.length; j > 0; j--) {
                if (dp[j][i] == result && str1[i - 1] == str2[j - 1] && dp[j][i] > dp[j - 1][i]) {
                    out.append(str1[i - 1]);
                    result--;
                    break;
                }
            }
            i--;
        }

        System.out.println(dp[str2.length][str1.length]);
        System.out.println(out.reverse());
    }
}
