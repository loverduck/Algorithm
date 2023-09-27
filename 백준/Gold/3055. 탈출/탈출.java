import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder output = new StringBuilder();

	static char[][] map;
	static boolean[][] waterVisited;
	static Queue<int[]> water = new ArrayDeque();
	static int[] hedgehog;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int r, c;
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][];
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'S') {
					hedgehog = new int[] {i, j, 0};
				} else if (map[i][j] == '*') {
					water.offer(new int[] {i, j});
				}
			}
		}
		
		bfs();
		System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
		
	}

	
	public static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[r][c];
		queue.offer(hedgehog);
		visited[hedgehog[0]][hedgehog[1]] = true;
		
		while(!queue.isEmpty()) {
			int waterCnt = water.size();
			for(int i = 0; i < waterCnt; i++) {
				int[] target = water.poll();
				int tx = target[0];
				int ty = target[1];
				
				for(int j = 0; j < 4; j++) {
					int x = tx + dx[j];
					int y = ty + dy[j];
					if(x >= 0 && x < r && y >= 0 && y < c && map[x][y] == '.') {
						map[x][y] = '*';
						water.add(new int[] {x, y});
					}
				}
			}
			
			int hCnt = queue.size();
			for(int i = 0; i < hCnt; i++) {
				int[] p = queue.poll();
				
				int px = p[0];
				int py = p[1];
				
				
				for(int j = 0; j < 4; j++) {
					int x = px + dx[j];
					int y = py + dy[j];
					
					if(x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]) {
						if(map[x][y] == 'D') {
							result = Math.min(result, p[2] + 1);
							return;
						} else if(map[x][y] == '.') {
							visited[x][y] = true;
							queue.add(new int[] {x, y, p[2] + 1});							
						}
					}
				}
			}
			
		}
	}
}