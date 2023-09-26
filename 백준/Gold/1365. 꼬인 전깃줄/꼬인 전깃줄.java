import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st = null;
	
	public static int[] arr;
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		Arrays.fill(arr, n + 1);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				if(arr[j] > num) {
					arr[j] = num;
					max = Math.max(max, j);
					break;
				}
			}
			
		}
		
		System.out.println(n - (max + 1));
	}
}