
import java.util.*;
import java.io.*;

public class Solution {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static int n, w, h, cnt, minCnt, originalCnt, map[][], originMap[][];
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= t; testCase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			minCnt = Integer.MAX_VALUE;
			
			originMap = new int[h][w];
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					originMap[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = originMap[i][j];
				}
			}
			
			dupCombination(0, new int[n]);
			
			
			output.append("#").append(testCase).append(" ").append(minCnt).append("\n");
		}
		System.out.println(output);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[h][w];

		queue.offer(new int[] {x, y, map[x][y]});
		map[x][y] = 0;
		cnt++;
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] target = queue.poll();
			int tx = target[0];
			int ty = target[1];
			int tRange = target[2] - 1;
			
			for(int i = tx - tRange; i <= tx + tRange; i++) {
				if(i >= 0 && i < h && map[i][ty] != 0 && !visited[i][ty]) {
					if(map[i][ty] > 1) {
						queue.offer(new int[] {i, ty, map[i][ty]});
					}
					map[i][ty] = 0;
					visited[i][ty] = true;
					cnt++;
				}
			}
			
			for(int i = ty - tRange; i <= ty + tRange; i++) {
				if(i >= 0 && i < w && map[tx][i] != 0 && !visited[tx][i]) {
					if(map[tx][i] > 1) {
						queue.offer(new int[] {tx, i, map[tx][i]});
					}
					map[tx][i] = 0;
					visited[tx][i] = true;
					cnt++;
				}
			}
			
		}
	}
	
	
	public static void dupCombination(int depth, int[] arr) {
		if(arr.length == depth) {
			cnt = 0;
			// 배열 복사
			copy();
			for(int a: arr) {
				bfs(findTop(a), a);
				fall();
			}
			minCnt = Math.min(minCnt, blockCnt());
			return;
		}
		
		for(int i = 0; i < w; i++) {
			arr[depth] = i;
			dupCombination(depth + 1, arr);
		}
	}
	
	public static void fall() {
		for(int i = 0; i < w; i++) {
			int target = h - 1;
			for(int j = h - 1; j >= 0; j--) {
				if(map[j][i] != 0) {
					if(j != target) {
						map[target][i] = map[j][i];
						map[j][i] = 0;
					}
					target = target - 1;
				}
			}
		}
	}
	
	public static int blockCnt() {
		int count = 0;		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void copy() {
		for(int i = 0; i < h; i++) {
			map[i] = Arrays.copyOf(originMap[i], originMap[i].length);
		}
	}
	
	public static int findTop(int y) {
		for(int i = 0; i < h; i++) {
			if(map[i][y] != 0) {
				return i;
			}
		}
		return h - 1;
	}
}
