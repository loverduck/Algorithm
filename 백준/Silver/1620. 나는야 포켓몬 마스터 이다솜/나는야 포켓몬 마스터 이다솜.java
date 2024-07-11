import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();


        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            hash1.put(i, S);
            hash2.put(S, i);
        }

        for(int i = 0; i < M; i++) {
            String S = br.readLine();

            if(49 <= S.charAt(0) && S.charAt(0) <= 57) {
                out.append(hash1.get(Integer.parseInt(S))).append("\n");
            }else {
                out.append(hash2.get(S)).append("\n");
            }
        }
        System.out.println(out);


    }
}
