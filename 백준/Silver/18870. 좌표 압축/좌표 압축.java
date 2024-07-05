import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] copyArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = copyArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(copyArr);

        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copyArr[i])) {
                map.put(copyArr[i], rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            out.append(map.get(arr[i])).append(" ");
        }
        System.out.println(out);
    }
}
