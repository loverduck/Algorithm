import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int F, S, G, U, D;
    static int Ans = -1;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        Ans = bfs();

        if(Ans >= 0) System.out.println(Ans);
        else System.out.println("use the stairs");
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;

        int size = 0;
        int count = -1;
        while (!queue.isEmpty()) {
            size = queue.size();
            count++;
            for (int step = 0; step < size; step++) {
                int cur = queue.poll();

                if(cur == G) return count;

                if (cur + U <= F && !visited[cur + U]) {
                    queue.offer(cur + U);
                    visited[cur + U] = true;
                }
                if (cur - D > 0 && !visited[cur - D]) {
                    queue.offer(cur - D);
                    visited[cur - D] = true;
                }
            }
        }
        return -1;
    }
}
