import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static int n, map[][];
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0, "");
		System.out.println(result);
	}
	
	// direct - 가로: 0, 세로: 1, 대각선: 2
	private static void dfs(int x, int y, int direct, String d) {
		if(x == n - 1 && y == n - 1) {
			result++;
			//System.out.println(d);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(direct == 2 || i == 2 || i == direct) { // 못가는 방향 제외
				int px = x + dx[i];
				int py = y + dy[i];

				//System.out.println("(" + x + ", " + y + ")를 "+ i + "로 이동해보기 -> " + "(" + px + ", " + py + ") ");
			
				
				if(px < 0 || px >= n || py < 0 || py >= n || map[px][py] == 1) continue; // 범위 벗어나는지 확인
				if(i == 2 && (map[px - 1][py] == 1 || map[px][py - 1] == 1)) continue;
				
				//System.out.println(i + "범위 가넝한");
				
				dfs(x + dx[i], y + dy[i], i, d + i);					
			}
		}
		//System.out.println("dfs 종료");
	}
}
