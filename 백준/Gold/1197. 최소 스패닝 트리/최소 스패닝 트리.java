import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int parent[], edges[][];


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		edges = new int[e][];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new int[] {a, b, c};
		}
		
		Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

		parent = new int[v];
		for (int i = 0; i < v; i++) {
			parent[i] = i;
		}

		int result = 0;
		for (int i = 0; i < e; i++) {
			if(find(edges[i][0]) == find(edges[i][1])) continue;

			union(edges[i][0], edges[i][1]);
			result += edges[i][2];
		}

		System.out.println(result);

	}

	public static int find(int a) {
		if(parent[a] != a) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}

	public static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);

		if(p1 == p2) return;

		if(p1 > p2) parent[p1] = parent[p2];
		else parent[p2] = parent[p1];
	}


}
