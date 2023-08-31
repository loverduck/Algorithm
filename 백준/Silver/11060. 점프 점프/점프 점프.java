import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	static int n, arr[], d[];
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		d = new int[n];
		
		Arrays.fill(d, -1);
		d[0] = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		for(int i = 0; i < n; i++) {
			if(d[i] == -1) continue;
			
			for(int j = i + 1; j < i + arr[i] + 1; j++) {
				if(j >= n) break;
				
				if(d[j] != -1) {
					d[j] = Math.min(d[j], d[i] + 1);					
				} else {
					d[j] = d[i] + 1;
				}
			}
		}
		
		System.out.println(d[n - 1]);
	}

	
}