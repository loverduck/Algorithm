import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static ArrayList<ArrayList<Integer>> friendship;
	static boolean result;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		friendship = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			friendship.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friendship.get(a).add(b);
			friendship.get(b).add(a);
		}
		
		result = false;
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			dfs(i, 1, visited);
			if(result) break;
		}
		System.out.println(result ? 1 : 0);
	}
	
	static void dfs(int num, int depth, boolean[] visited) {
		if(depth == 5) {
			result = true;
			return;
		}
	
		visited[num] = true;
		for(int i : friendship.get(num)) {
			if(!visited[i]) dfs(i, depth + 1, visited);
			if(result) return;
		}
		visited[num] = false;
	}

}