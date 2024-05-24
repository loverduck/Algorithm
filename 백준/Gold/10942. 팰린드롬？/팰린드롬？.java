import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int n;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s == e) {
                out.append(1).append("\n");
                continue;
            }

            boolean flag = true;
            while (s <= e) {
                if (arr[s] != arr[e]) {
                    flag = false;
                    break;
                }
                s++;
                e--;
            }

            if (flag) {
                out.append(1).append("\n");
            } else {
                out.append(0).append("\n");
            }

        }
        System.out.println(out);
    }

}
