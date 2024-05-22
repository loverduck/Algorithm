import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dupPer(0, new int[m]);
		System.out.println(out);
	}

	public static void dupPer(int idx, int[] selected) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				out.append(selected[i]).append(" ");
			}
			out.append("\n");
			return;
		}

		int num = 1;
		if (idx != 0) {
			num = selected[idx - 1];
		}

		for (int i = num; i <= n; i++) {
			selected[idx] = i;
			dupPer(idx + 1, selected);
		}
	}
}
