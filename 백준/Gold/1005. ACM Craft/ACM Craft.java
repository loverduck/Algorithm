import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] cost;
    static List<Integer>[] graph;
    static int[] need;
    static int build, result, n;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cost = new int[n + 1];
            need = new int[n + 1];
            graph = new ArrayList[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                need[end]++;
            }

            result = 0;
            build = Integer.parseInt(br.readLine());
            find(build);
        }
        System.out.println(out);
    }

    public static void find(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = cost[i];
            if (need[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int target = queue.poll();
            for (int i: graph[target]) {
                time[i] = Math.max(time[i], time[target] + cost[i]);
                need[i]--;
                if (need[i] == 0) queue.add(i);
            }
        }
        out.append(time[idx]).append("\n");
    }
}
