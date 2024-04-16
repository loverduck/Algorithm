import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int n, players[], score[];
	static int exist[];
	static final int MAX_NUMBER = 1000000;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		score = new int[MAX_NUMBER + 1];
		exist = new int[MAX_NUMBER + 1];
		players = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			players[i] = Integer.parseInt(st.nextToken());
			exist[players[i]] = players[i];
		}

		for (int i = 1; i <= MAX_NUMBER; i++) {
			if(exist[i] == 0) continue;

			for (int j = 2 * i; j <= MAX_NUMBER ; j += i) {
				if(exist[j] != 0) {
					score[i]++;
					score[j]--;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			out.append(score[players[i]]).append(" ");
		}
		System.out.println(out);

	}


}
