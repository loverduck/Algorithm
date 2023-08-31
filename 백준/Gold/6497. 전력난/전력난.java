import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static int m, n, distance, count, totalDistance;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static void make() {
		parents = new int[m];
		for (int i = 0; i < m; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 싸이클이 발생했다는 의미로 해석된다!
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 집의 수
			n = Integer.parseInt(st.nextToken()); // 도로 수
			
			edgeList = new Edge[n];
			totalDistance = 0;
			distance = 0;
            count = 0;
			
			if(m == 0 && n == 0) break;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
				totalDistance += weight;	
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			for(Edge e: edgeList) {
				if(union(e.from, e.to)) {
					distance += e.weight;
					if(++count == m - 1) break;
				}
			}
			
			output.append(totalDistance - distance).append("\n");
		}
		
		System.out.println(output);
	}

}