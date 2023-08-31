import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] d =  new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(i == 0) {
					d[i][j] = arr[i][j];
				} else {
					if(j == 0) {
						d[i][j] = Math.min(d[i - 1][1], d[i - 1][2]) + arr[i][j];
					} else if(j == 1) {
						d[i][j] = Math.min(d[i - 1][0], d[i - 1][2]) + arr[i][j];
					} else {
						d[i][j] = Math.min(d[i - 1][0], d[i - 1][1]) + arr[i][j];
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++) {
			result = Math.min(d[n - 1][i], result);
		}
		System.out.println(result);
	}

}