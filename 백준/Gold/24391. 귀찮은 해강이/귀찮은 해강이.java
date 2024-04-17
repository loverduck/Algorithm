import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] parents, plan;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        plan = new int[n];

        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            int p1 = find(plan[i - 1]);
            int p2 = find(plan[i]);

            if(p1 != p2) result += 1;
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) return;

        if(p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;
    }

    public static int find(int n) {
        if(parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }

}
