import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[n + 1];
		d[0] = 0;
		d[1] = 0;
		
		for(int i = 2; i < n + 1; i++) {
			
			if(i % 6 == 0) {
				d[i] = Math.min(d[i / 2] + 1, d[i / 3] + 1);
				d[i] = Math.min(d[i], d[i - 1] + 1);
			} else if(i % 2 == 0) {
				d[i] = Math.min(d[i - 1] + 1, d[i / 2] + 1);
			} else if(i % 3 == 0) {
				d[i] = Math.min(d[i - 1] + 1, d[i / 3] + 1);
			} else {
				d[i] = d[i - 1] + 1;
			}
		}
		
		System.out.println(d[n]);
	}

}