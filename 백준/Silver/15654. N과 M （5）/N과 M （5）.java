import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		dupCom(0, new int[m], new boolean[n]);
		System.out.println(out);
	}

	public static void dupCom(int idx, int[] selected, boolean[] visited) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				out.append(selected[i]).append(" ");
			}
			out.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[idx] = arr[i];
			dupCom(idx + 1, selected, visited);
			visited[i] = false;
		}
	}
}
