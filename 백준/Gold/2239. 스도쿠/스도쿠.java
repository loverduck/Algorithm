import java.io.*;
import java.util.*;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder output = new StringBuilder();
	
	public static int[][] sudoku = new int[9][9];
	public static List<int[]> blank = new ArrayList<>();
	public static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		
		// 스도쿠 빈칸 찾기
		
		for(int i = 0; i < 9; i++) {
			String line = br.readLine();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = line.charAt(j) - '0';
				if(sudoku[i][j] == 0) {
					blank.add(new int[] {i, j});
				}
				
			}
		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				output.append(sudoku[i][j]);
			}

			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	public static void dfs(int depth) {
		if(depth == blank.size()) {
			flag = true;
			return;
		}
		
		int[] point = blank.get(depth);
		int x = point[0];
		int y = point[1];
		
		for(int i = 1; i < 10; i++) {
			if(isValid(x, y, i)) {
				sudoku[x][y] = i;
				dfs(depth + 1);
				
				if(flag) return;
				
				sudoku[x][y] = 0;
			}
		}
		
	}
	
	public static boolean isValid(int x, int y, int num) {
		
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][y] == num || sudoku[x][i] == num) {
				return false;
			}
		}
		
		int tx = (int)(x / 3) * 3;
		int ty = (int)(y / 3) * 3;
		for(int i = tx; i < tx + 3; i++) {
			for(int j = ty; j < ty + 3; j++) {
				if(sudoku[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}

}