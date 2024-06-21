import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[][] map, disMap;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[] goal;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        disMap = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                disMap[i][j] = -1;
                if (map[i][j] == 2) {
                    disMap[i][j] = 0;
                    queue.offer(new int[] {i, j, 0});
                } else if (map[i][j] == 0) {
                    disMap[i][j] = 0;
                }
            }
        }


        while(!queue.isEmpty()) {
            int[] target = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = target[0] + dx[i];
                int y = target[1] + dy[i];
                int count = target[2];

                if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 0) continue;

                if (disMap[x][y] != -1) continue;

                disMap[x][y] = count + 1;
                queue.offer(new int[] {x, y, count + 1});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.append(disMap[i][j]).append(" ");
            }
            out.append("\n");
        }

        System.out.println(out);
    }
}
