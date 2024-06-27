import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] idx;
    static int[] fuel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        idx = new int[n];
        fuel = new int[n];
        visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        queue.offer(s - 1);
        visited[s - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentPos = idx[current];
            int currentFuel = fuel[current];

            for (int i = current + 1; i < n; i++) {
                if (!visited[i] && idx[i] <= currentPos + currentFuel) {
                    queue.offer(i);
                    visited[i] = true;
                } else if (idx[i] > currentPos + currentFuel) {
                    break;
                }
            }

            for (int i = current - 1; i >= 0; i--) {
                if (!visited[i] && idx[i] >= currentPos - currentFuel) {
                    queue.offer(i);
                    visited[i] = true;
                } else if (idx[i] < currentPos - currentFuel) {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                out.append(i + 1).append(" ");
            }
        }
        System.out.println(out);
    }
}
