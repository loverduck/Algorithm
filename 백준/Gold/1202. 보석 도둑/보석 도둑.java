import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] bag;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Jewel[] jewels = new Jewel[n];
        bag = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels);


        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        int idx = 0;
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int b: bag) {
            while(idx < n) {
                if(jewels[idx].mass > b) break;
                pq.offer(jewels[idx].value);
                idx += 1;
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    public static class Jewel implements Comparable<Jewel> {
        int mass, value;

        Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            if(this.mass == o.mass) {
                return o.value - this.value;
            }
            return this.mass - o.mass;
        }
    }
}
