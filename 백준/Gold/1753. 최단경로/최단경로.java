import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static class Node{
        int end;
        int weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int k = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[v + 1];
        ArrayList<Node>[] arr = new ArrayList[v + 1];
        int[] distance = new int[v + 1];

        for(int i = 1; i <= v; i++){
            arr[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, w));
        }

        distance[0] = Integer.MAX_VALUE;
        visited[k] = true;
        distance[k] = 0;
        for(Node x : arr[k]){
            distance[x.end] = Math.min(distance[x.end], x.weight);
        }

        for(int i = 2; i <= v; i++){
            int min = 0;
            for(int j = 1; j <= v; j++){
                if(!visited[j] && distance[min] > distance[j]){
                    min = j;
                }
            }
            if(min == 0) break;
            visited[min] = true;

            for(Node x : arr[min]){
                distance[x.end] = Math.min(distance[x.end], distance[min] + x.weight);
            }
        }

        for(int i = 1; i <= v; i++){
            out.append(visited[i] ? distance[i] : "INF").append("\n");
        }
        System.out.println(out);
    }
}
