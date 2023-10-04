import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder output = new StringBuilder();
	
	public static int n, graph[][];

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new int[n + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1; 
		}
		
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			int count = bfs(i, true) + bfs(i, false);
			if(count == n - 1) result++; 
		}
		
		
		System.out.println(result);
	}
	
	public static int bfs(int num, boolean asc) {
		
		Queue<Integer> queue = new ArrayDeque();
		boolean[] visited = new boolean[n + 1];
		int cnt = 0;
		
		queue.add(num);
		visited[num] = true;
		
		while(!queue.isEmpty()) {
			int target = queue.poll();
			
			for(int i = 1; i <= n; i++) {
				int edge = graph[target][i];
				if(!asc) {
					edge = graph[i][target];
				} 
				
				if(edge == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
