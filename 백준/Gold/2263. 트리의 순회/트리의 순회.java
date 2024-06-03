import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] inOrder, postOrder;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        inOrder = new int[n + 1];
        postOrder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            inOrder[num] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, n - 1, 0, n - 1);
        System.out.println(out);
    }

    public static void solve(int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart == postEnd) {
            out.append(postOrder[postStart]).append(" ");
            return;
        }

        int root = postOrder[postEnd];
        out.append(root).append(" ");
        int idx = inOrder[root];


        int leftCnt = idx - inStart;
        if (leftCnt != 0) {
            solve(postStart, postStart + leftCnt - 1, inStart, idx - 1);
        }

        int rightCnt = inEnd - idx;
        if (rightCnt != 0) {
            solve(postEnd - rightCnt, postEnd - 1, idx + 1, inEnd);
        }
    }

}
