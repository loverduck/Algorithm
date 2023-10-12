import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int maxHeight = 0;
			
			int[] trees = new int[n];
			
			for(int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(trees[i], maxHeight);
			}
			
			int odd = 0;
			int even = 0;
			
			for(int i = 0; i < n; i++) {
				int diff = maxHeight - trees[i];
				odd += diff % 2;
				even += (int)(diff / 2);
			}
			
			int result = 0;
			if(odd > even) {
				result = odd * 2 - 1;
			} else if(odd == even) {
				result = odd * 2;
			} else {
				result = odd * 2 + (int)((even - odd) * 2 / 3) * 2 + (even - odd) * 2 % 3;
			}
			
			output.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(output);
	}
}
