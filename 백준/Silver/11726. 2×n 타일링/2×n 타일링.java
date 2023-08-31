import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main  {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int memo[];
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		memo = new int[1001];
		
		Arrays.fill(memo, -1);
		
		memo[1] = 1;
		memo[2] = 2;
		
		System.out.println(fill(N));
	}

	static int fill(int n) {
		if(memo[n] == -1) {
			memo[n] = (fill(n - 1) + fill(n - 2)) % 10007;
		}
		
		return memo[n];
	}
}