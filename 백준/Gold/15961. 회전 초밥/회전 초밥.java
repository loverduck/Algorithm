import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static int n, d, k, c, count, maxCount, sushi[], type[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[n];
		type = new int[d + 1];
		
		for(int i = 0; i < n; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(i < k) {
				if(type[sushi[i]]++ == 0) count++;
			}
		}

		int start = 0;
		int end = k - 1;
		maxCount = 0;
		while(start < n) {
			if(type[sushi[start]] - 1 == 0) count--;
			type[sushi[start++]]--;
			end = (end + 1) % n;
			if(type[sushi[end]]++ == 0) count++;
			maxCount = type[c] == 0 ? Math.max(maxCount, count + 1) : Math.max(maxCount, count);
		}
		
		System.out.println(maxCount);
	}

}