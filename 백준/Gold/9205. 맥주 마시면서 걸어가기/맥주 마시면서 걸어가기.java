import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= t; testCase++) {
			
			int n = Integer.parseInt(br.readLine());
			List<int[]> cs = new ArrayList<>();
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				cs.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			boolean[][] d = new boolean[n + 2][n + 2];
			for(int i = 0; i < n + 2; i++) {
				for(int j = i + 1; j < n + 2; j++) {
					int[] point1 = cs.get(i);
					int[] point2 = cs.get(j);
					
					int distance = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
					d[i][j] = d[j][i] = distance <= 1000;
				}
			}
			
			for(int k = 0; k < n + 2; k++) {
				for(int i = 0; i < n + 2; i++) {
					for(int j = 0; j < n + 2; j++) {
						if(d[i][k] && d[k][j]) {
							d[i][j] = true;
						}
					}
				}
			}
			
			String result = d[0][n + 1] ? "happy" : "sad";
			output.append(result).append("\n");
		}
		
		System.out.println(output);
	}

}