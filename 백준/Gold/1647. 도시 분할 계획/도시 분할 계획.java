import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;
    static int[][] edge;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        edge = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edge[i] = new int[] {start, end, weight};
        }

        Arrays.sort(edge, Comparator.comparingInt(o -> o[2]));

        int count = 0;
        int result = 0;
        int i = 0;
        while(count < n - 2) {
            if(find(edge[i][0]) == find(edge[i][1])) {
                i++;
                continue;
            };

            union(edge[i][0], edge[i][1]);
            result += edge[i][2];
            count++;
            i++;
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 == p2) return;

        if(p1 > p2) parent[p1] = parent[p2];
        else parent[p2] = parent[p1];
    }

    public static int find(int n) {
        if(parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

}
