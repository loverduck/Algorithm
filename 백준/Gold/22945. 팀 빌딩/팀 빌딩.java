import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] lines = new int[n];

        int start = 0, end = n - 1, result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(st.nextToken());
        }

        while(start != end) {
            result = Math.max(result, Math.min(lines[start], lines[end]) * (end - start - 1));
            if(lines[start] < lines[end]) start++;
            else end--;
        }
        System.out.println(result);
    }
}
