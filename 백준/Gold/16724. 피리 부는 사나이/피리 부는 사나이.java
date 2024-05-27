import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static char[][] map;
    static int[][] visited;
    static int result;

    static int index;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        index = 1;
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, index);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, int idx) {
        if (visited[x][y] != 0) {
            if(visited[x][y] == idx) {
                result += 1;
            }
            index += 1;
            return;
        }

        visited[x][y] = idx;

        if (map[x][y] == 'D') {
            dfs(x + 1, y, idx);
        } else if (map[x][y] == 'U') {
            dfs(x - 1, y, idx);
        } else if (map[x][y] == 'L') {
            dfs(x, y - 1, idx);
        } else {
            dfs(x, y + 1, idx);
        }
    }

}
