import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);

            boolean[] visited = new boolean[n];

            while (!queue.isEmpty()) {
                int target = queue.poll();
                visited[target] = true;

                for (int j = 0; j < n; j++) {
                    if (arr[target][j] == 1) {
                        temp[i][j] = 1;
                        if(!visited[j]) queue.offer(j);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.append(temp[i][j]).append(" ");
            }
            out.append("\n");
        }

        System.out.println(out);
    }
}
