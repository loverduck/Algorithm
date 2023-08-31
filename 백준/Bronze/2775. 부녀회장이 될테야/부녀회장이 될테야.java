import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < t; testCase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			output.append(findPeople(k, n)).append("\n");
		}
		System.out.println(output);
	}
	
	public static int findPeople(int k, int n) {
		if(n == 1) {
			return 1;
		}
		if(k == 1) {
			return n * (n + 1) / 2;
		}
		return findPeople(k, n - 1) + findPeople(k - 1, n);
	}

}
