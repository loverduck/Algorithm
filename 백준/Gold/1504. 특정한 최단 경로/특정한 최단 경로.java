import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int n;
    static List<Node>[] arrList;
    static int[] dist;
    static final int INF = 1000 * 200_000 + 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        arrList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList[start].add(new Node(end, weight));
            arrList[end].add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int startToV1 = dijkstra(1, v1);
        int startToV2 = dijkstra(1, v2);
        int v1ToV2 = dijkstra(v1, v2);
        int v1ToEnd = dijkstra(v1, n);
        int v2ToEnd = dijkstra(v2, n);

        int result = Math.min(startToV1 + v2ToEnd, startToV2 + v1ToEnd);
        result += v1ToV2;
        result = result < INF ? result : -1;
        System.out.println(result);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node target = pq.poll();

            if (visited[target.end]) continue;
            visited[target.end] = true;

            for (int i = 0; i < arrList[target.end].size(); i++) {
                Node next = arrList[target.end].get(i);

                if(next.weight + dist[target.end] < dist[next.end]) {
                    dist[next.end] = next.weight + dist[target.end];
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[end];
    }
}
