import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[] doyeon;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    doyeon = new int[] {i, j};
                    break;
                }
            }
        }


        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(doyeon);

        int result = 0;
        while(!queue.isEmpty()) {
            int[] target = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = target[0] + dx[i];
                int y = target[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 'X') continue;

                if (visited[x][y]) continue;

                visited[x][y] = true;

                if (map[x][y] == 'P') result += 1;
                queue.offer(new int[] {x, y});
            }
        }

        System.out.println(result == 0 ? "TT" : result);
    }
}
