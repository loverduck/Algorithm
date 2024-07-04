import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();

    static int n, m;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new int[] {i, j});
                } else if (num == 2) {
                    chicken.add(new int[] {i, j});
                }
            }
        }

        comb(0, 0, new ArrayList<>());
        System.out.println(minDistance);
    }

    public static void comb(int nth, int startIdx, List<int[]> selected) {
        if (nth == m) {
            int totalDistance = 0;
            for (int[] h: house) {
                int min = Integer.MAX_VALUE;
                for (int[] s: selected) {
                    int distance = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(min, distance);
                }
                totalDistance += min;
            }
            minDistance = Math.min(minDistance, totalDistance);
            return;
        }

        for (int i = startIdx; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            comb(nth + 1, i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
