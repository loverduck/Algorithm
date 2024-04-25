import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int n, m;
	static int[][] vertex;
	static int[] route, parent;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		vertex = new int[n][n];
		route = new int[m];
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				vertex[i][j] = Integer.parseInt(st.nextToken());
				if(vertex[i][j] == 1 && find(i) != find(j)) union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			route[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 0; i < m - 1; i++) {
			if(find(route[i]) != find(route[i + 1])) {
				System.out.println("NO");
				return;
			}

		}
		System.out.println("YES");
	}

	public static int find(int n) {
		if(parent[n] != n) {
			parent[n] = find(parent[n]);
		}
		return parent[n];
	}

	public static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);

		if(parent[p1] > parent[p2]) {
			parent[p1] = parent[p2];
		} else {
			parent[p2] = parent[p1];
		}
	}

}
