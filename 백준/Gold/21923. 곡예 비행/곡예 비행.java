import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[][] board, upDP, downDP;
    static boolean[][] upVisit, downVisit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        upDP = new int[n][m];
        downDP = new int[n][m];
        upVisit = new boolean[n][m];
        downVisit = new boolean[n][m];

        int max = findDown(n - 1, m - 1);

        System.out.println(max);
    }

    static int findUP(int r, int c) {

        if (upVisit[r][c]) return upDP[r][c];
        upVisit[r][c] = true;

        if (r == n - 1 && c == 0) return upDP[r][c] = board[n - 1][0];

        if (r == n - 1) return upDP[r][c] = findUP(r, c - 1) + board[r][c];

        if (c == 0) return upDP[r][c] = findUP(r + 1, c) + board[r][c];

        return upDP[r][c] = Math.max(findUP(r + 1, c), findUP(r, c - 1)) + board[r][c];
    }

    static int findDown(int r, int c) {

        if (downVisit[r][c]) return downDP[r][c];
        downVisit[r][c] = true;

        if (r == 0 && c == 0) return downDP[r][c] = findUP(0,0)+board[0][0];

        if (r == 0) return downDP[r][c] = Math.max(findUP(r, c), findDown(r, c - 1)) + board[r][c];

        if (c == 0) return downDP[r][c] = Math.max(findUP(r, c), findDown(r - 1, c)) + board[r][c];

        return downDP[r][c] = Math.max(findUP(r, c), Math.max(findDown(r - 1, c), findDown(r, c - 1))) + board[r][c];

    }

}
