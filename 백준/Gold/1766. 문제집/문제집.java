import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static List<Integer>[] problems;
    static int[] next;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        problems = new List[n + 1];
        next = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            problems[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            problems[start].add(end);
            next[end]++;
        }


        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (next[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int target = queue.poll();
            out.append(target).append(" ");
            for (int nextP: problems[target]) {
                next[nextP]--;
                if (next[nextP] == 0) {
                    queue.offer(nextP);
                }
            }
        }

        System.out.println(out);
    }
}
