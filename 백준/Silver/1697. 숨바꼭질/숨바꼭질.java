import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int[] d;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		d = new int[100001];
		visited = new boolean[100001];
		for (int i = 0; i < 100001; i++) {
			d[i] = Math.abs(i - n);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			int target = queue.poll();
			visited[target] = true;

			if(target - 1 >= 0) {
				d[target - 1] = Math.min(d[target - 1], d[target] + 1);
				if (!visited[target - 1]) queue.offer(target - 1);
			}
			if(target * 2 < 100001) {
				d[target * 2] = Math.min(d[target] + 1, d[target * 2]);
				if (!visited[target * 2]) queue.offer(target * 2);
			}
			if(target + 1 < 100001) {
				d[target + 1] = Math.min(d[target + 1], d[target] + 1);
				if (!visited[target + 1]) queue.offer(target + 1);
			}
		}

		System.out.println(d[k]);
	}
}
