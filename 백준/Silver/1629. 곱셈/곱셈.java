import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b, c));
    }

    public static long pow(long a, long b, long c) {
        if(b == 0) return 1;
        long n = pow(a,b / 2, c);
        if(b % 2 == 1) return (n * n % c) * a % c;
        return n * n % c;
    }
}
