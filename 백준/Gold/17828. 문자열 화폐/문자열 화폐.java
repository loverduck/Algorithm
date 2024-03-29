import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[] str = new char[n];
        if(x < n || x > n * 26) {
            System.out.println("!");
            return;
        }

        int zCnt = (x - n) / 25;
        int mod = (x - n) % 25;

        for (int i = 0; i < n; i++) {
            if (i < zCnt) {
                str[n - 1 - i] = 'Z';
            } else if (i == zCnt && mod != 0) {
                str[n - 1 - i] = (char)(65 + mod);
            } else {
                str[n - 1 - i] = 'A';
            }
        }
        System.out.println(new String(str));
    }
}
