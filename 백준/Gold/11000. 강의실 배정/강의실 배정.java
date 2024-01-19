import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Lession implements Comparable<Lession> {
        int start, end;

        public Lession(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lession o) {
            if(this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Lession> lessions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lessions.add(new Lession(s, t));
        }

        Collections.sort(lessions);
        Queue<Integer> queue = new PriorityQueue<>();
        int cTime = 0;

        for (Lession l: lessions) {
            cTime = l.end;
            if(!queue.isEmpty() && queue.peek() <= l.start) queue.poll();
            queue.add(cTime);
        }

        System.out.println(queue.size());
    }
}
