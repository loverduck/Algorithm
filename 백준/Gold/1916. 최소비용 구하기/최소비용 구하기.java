import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int value;

    Node(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<List<Node>> arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, value));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!check[cur]) {
                check[cur] = true;
                for(Node node: arr.get(cur)) {
                    if(!check[node.end] && dist[node.end] > dist[cur] + node.value) {
                        dist[node.end] = dist[cur] + node.value;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }

            }
        }

        System.out.println(dist[end]);
    }


}
