import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] arr;
    static boolean[] visited;
    static int result;
    static int[] path;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            path = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;
                dfs(j, 1);
            }
            out.append(result).append("\n");
        }
        System.out.println(out);
    }

    public static void dfs(int num, int depth) {
        if (visited[num]) {
            result += (depth - 1);
            return;
        }

        path[num] = depth;
        visited[num] = true;
        if (path[arr[num]] != 0) {
            result += (path[arr[num]] - 1);
            path[num] = 0;
            return;
        }

        dfs(arr[num], depth + 1);
        path[num] = 0;
    }
}
