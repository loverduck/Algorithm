
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static final long M = 1234567891;
	static long[] f = new long[1000001];
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		makeF();
		
		for(int testCase = 1; testCase <= t; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			
			long a = f[n];
			long b = (f[n - r] * f[r]) % M;
			
			long answer = a * power(b, M - 2) % M;
			
			output.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(output);
	}
	
	private static void makeF() {
		f[0] = 1;
		for(int i = 1; i <= 1000000; i++) {
			f[i] = f[i - 1] * i % M;
		}
	}
	
	private static long power(long n, long k) {
		if(k == 1) {
			return n;
		}
		long x = power(n, (int)(k / 2));
		if(k % 2 == 0) {
			return x * x % M;
		} else {
			return (x * x % M * n) % M;
		}
	}
}
