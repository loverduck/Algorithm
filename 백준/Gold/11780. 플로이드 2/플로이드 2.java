import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[][] map;
    static List<Integer>[][] route;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        route = new ArrayList[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i != j) map[i][j] = 1000000000;
                route[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(c, map[a][b]);
        }

        floyd();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1000000000) {
                    out.append("0").append(" ");
                } else {
                    out.append(map[i][j]).append(" ");
                }
            }
            out.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || map[i][j] == 1000000000) {
                    out.append("0").append("\n");
                } else {
                    out.append(route[i][j].size() + 2).append(" ");
                    out.append(i).append(" ");
                    for (int num: route[i][j]) {
                        out.append(num).append(" ");
                    }
                    out.append(j).append("\n");
                }
            }
        }

        System.out.println(out);
    }

    public static void floyd() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                        findRoute(j, i, k);
                    }
                }
            }
        }
    }

    public static void findRoute(int start, int layover, int end) {
        route[start][end].clear();
        route[start][end].addAll(route[start][layover]);
        route[start][end].add(layover);
        route[start][end].addAll(route[layover][end]);
    }
}
