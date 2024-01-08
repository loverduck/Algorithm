import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.size() == 0)
                        continue;

                    int n = num == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(n, map.get(n) - 1) == 1)
                        map.remove(n);
                }
            }

            if (map.isEmpty()) output.append("EMPTY").append('\n'); // TreeMap이 비어있으면 "EMPTY" 저장
            else output.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
        }
        System.out.println(output);
    }
}
