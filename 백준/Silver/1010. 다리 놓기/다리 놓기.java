import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static int r, n, dp[][];
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= t; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			dp = new int[n + 1][r + 1];
			
			output.append(bc(n, r)).append("\n");
			
		}
		System.out.println(output);
	}

	static int bc(int n, int r) {
		if(dp[n][r] > 0) return dp[n][r];
		
		if(n == r || r == 0) return dp[n][r] = 1;
		
		return dp[n][r] = bc(n - 1, r - 1) + bc(n - 1, r);
	
	}
}