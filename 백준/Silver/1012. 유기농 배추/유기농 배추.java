import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[][] map;
    static int count;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};

    static int m, n;

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1) {
                        bfs(j, l);
                    }
                }
            }

            out.append(count).append("\n");
        }
        System.out.println(out);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        map[x][y] = 0;

        count++;

        while(!queue.isEmpty()) {
            int[] target = queue.poll();
            int curX = target[0];
            int curY = target[1];


            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;

                queue.offer(new int[] {nextX, nextY});
                map[nextX][nextY] = 0;
            }
        }
    }
}
