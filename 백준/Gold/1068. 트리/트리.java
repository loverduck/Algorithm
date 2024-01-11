import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;
    static boolean[] visited;
    static int n, count, root = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }

        deleteNode(Integer.parseInt(br.readLine()));
        findLeaf(root);

        System.out.println(count);
    }

    public static void deleteNode(int idx) {
        parent[idx] = -2;
        visited[idx] = true;
        for (int i = 0; i < n; i++) {
            if(parent[i] == idx) {
                deleteNode(i);
            }
        }
    }

    public static void findLeaf(int idx) {
        boolean isLeaf = true;
        visited[idx] = true;
        if(parent[idx] != -2) {
            for(int i = 0; i < n; i++) {
                if(parent[i] == idx && !visited[i]) {
                    findLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }
}
