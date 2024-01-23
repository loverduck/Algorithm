import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    public static class Problem implements Comparable<Problem> {
        int number, difficult;
        Problem(int n, int d) {
            this.number = n;
            this.difficult = d;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.difficult == o.difficult) {
                return this.number - o.number;
            } else {
                return this.difficult - o.difficult;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TreeSet<Problem> asc = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficult = Integer.parseInt(st.nextToken());

            asc.add(new Problem(number, difficult));
            map.put(number, difficult);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1)
                    out.append(asc.last().number).append("\n");
                else
                    out.append(asc.first().number).append("\n");
            } else {
                int number = Integer.parseInt(st.nextToken());

                if(command.equals("add")) {
                    int difficult = Integer.parseInt(st.nextToken());

                    asc.add(new Problem(number, difficult));
                    map.put(number, difficult);
                } else {
                    int difficult = map.get(number);

                    asc.remove(new Problem(number, difficult));
                    map.remove(number);
                }
            }
        }
        System.out.println(out);
    }
}
