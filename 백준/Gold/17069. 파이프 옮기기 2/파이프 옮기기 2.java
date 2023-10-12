import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static int n, map[][];
	static long d[][][];
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		d = new long[n + 1][n + 1][3];
		
		for(int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		d[1][2][0] = 1;
		
		for(int r = 1; r <= n; r++) {
			for(int c = 1; c <= n; c++) {
				if(map[r][c] == 1) continue;
				d[r][c][0] += (d[r][c - 1][0] + d[r][c - 1][2]);
				d[r][c][1] += (d[r - 1][c][1] + d[r - 1][c][2]);
				
				if(map[r - 1][c] == 1 || map[r][c - 1] == 1) continue;
				d[r][c][2] += (d[r - 1][c - 1][0] + d[r - 1][c - 1][1] + d[r - 1][c - 1][2]);
			}

		}
		System.out.println(d[n][n][0] + d[n][n][1] + d[n][n][2]);
	}
}
