import java.io.*;
import java.util.*;

public class Main {
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringTokenizer st;
    static private StringBuilder output = new StringBuilder();

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int m, n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] box;
    static Queue<Tomato> queue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) queue.offer(new Tomato(i, j, 0));
            }
        }

        int day = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = tomato.day;

            for (int i = 0; i < 4; i++) {
                int x = tomato.x + dx[i];
                int y = tomato.y + dy[i];

                if(0 <= x && x < n && 0 <= y && y < m && box[x][y] == 0) {
                    box[x][y] = 1;
                    queue.offer(new Tomato(x, y, day+1));
                }
            }
        }

        System.out.println(isRipe() ? day : -1);
    }


    public static boolean isRipe() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) return false;
            }
        }
        return true;
    }
}
