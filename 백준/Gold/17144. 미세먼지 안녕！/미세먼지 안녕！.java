import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();

	static int R, C, T, map[][], airCleaner;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		airCleaner = -1;
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1 && airCleaner == -1) airCleaner = r;
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		for(int t = 0; t < T; t++) {
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] != -1) {
						queue.offer(new int[] {r, c, map[r][c]});						
					}
				}
			}
			
			map = new int[R][C];
			map[airCleaner][0] = -1;
			map[airCleaner + 1][0] = -1;
			while(!queue.isEmpty()) {
				int[] target = queue.poll();
				int tx = target[0];
				int ty = target[1];
				int amount = target[2];
				int count = 0;
				
				for(int i = 0; i < 4; i++) {
					int x = tx + dx[i];
					int y = ty + dy[i];
					if(x < 0 || x >= R || y < 0 || y >= C || map[x][y] == -1) continue;
					map[x][y] += (int)(amount / 5);
					count++;
				}
				
				map[tx][ty] += amount - (int)(amount / 5) * count;
			}
			rotate();
		}
		dustCnt();
	}
	
	public static void rotate() {
		for(int i = airCleaner - 2; i >= 0; i--) {
			map[i + 1][0] = map[i][0];
		}
		
		for(int i = airCleaner + 3; i < R ;i++) {
			map[i - 1][0] = map[i][0];
		}
		
		for(int i = 1; i < C; i++) {
			map[0][i - 1] = map[0][i];
			map[R - 1][i - 1] = map[R - 1][i];
		}
		
		for(int i = 1; i <= airCleaner; i++) {
			map[i - 1][C - 1] = map[i][C - 1];
		}
		
		for(int i = R - 2; i > airCleaner; i--) {
			map[i + 1][C - 1] = map[i][C - 1];
		}
		
		for(int i = C - 2; i > 0; i--) {
			map[airCleaner][i + 1] = map[airCleaner][i];
			map[airCleaner + 1][i + 1] = map[airCleaner + 1][i];
		}
		
		map[airCleaner][1] = 0;
		map[airCleaner + 1][1] = 0; 
	}
	
	public static void dustCnt() {
		int cnt = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				cnt += map[r][c];
			}
		}
		System.out.println(cnt + 2);
    }
}
