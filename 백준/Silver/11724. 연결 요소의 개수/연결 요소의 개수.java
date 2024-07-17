import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[][] graph = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        floyd();

        int count = 0;
        boolean node[] = new boolean[n+1];
        for(int i=1; i<=n; i++) {


            if(node[i] == true) {
                continue;
            }

            for(int j=1; j<=n; j++) {
                if(graph[i][j] == 1 && node[j] == false) {
                    node[j] = true;
                }
            }

            count ++;
        }

        System.out.println(count);
    }

    static void floyd() {
        for(int k=0; k<=n; k++) {
            for(int i=0; i<=n; i++) {
                for(int j=0; j<=n; j++) {

                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

    }
}
