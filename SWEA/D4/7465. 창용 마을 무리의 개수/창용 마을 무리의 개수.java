import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static int N;
	static int parents[];
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= t; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			make();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from, to);
			}
			int answer = 0;
			for(int i = 1; i <= N ; i++) {
				if(parents[i] == i) {
					answer++;
				}
			}
			output.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(output);
	}
	
	private static void make() {
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;			
		} else {
			parents[aRoot] = bRoot;
		}
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return find(parents[a]);
	}

}
