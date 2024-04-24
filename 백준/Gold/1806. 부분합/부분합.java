import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();

	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;
        if(sum >= m) {
            min = 1;
        }
        
		while(end < n) {
			if(sum < m) {
				if(end == n - 1) {
                    if(sum >= m) {
                        min = Math.min(min, end - start + 1);
                    }
					break;
				}
				sum += arr[++end];
			} else if(sum >= m) {
				sum -= arr[start++];
			}
			if(sum >= m) {
				min = Math.min(min, end - start + 1);
			}
		}

		if(min == Integer.MAX_VALUE) {
			min = 0;
		}

		System.out.println(min);
	}
}
