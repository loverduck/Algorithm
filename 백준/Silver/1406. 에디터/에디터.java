import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String text = br.readLine();
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char c: text.toCharArray()) {
            left.offerLast(c);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L") && !left.isEmpty()) {
                right.offerFirst(left.pollLast());
            } else if (command.equals("D") && !right.isEmpty()) {
                left.offerLast(right.pollFirst());
            } else if (command.equals("B") && !left.isEmpty()) {
                left.pollLast();
            } else if (command.equals("P")) {
                char chr = st.nextToken().charAt(0);
                left.offerLast(chr);
            }
        }

        for (char c: left) {
            output.append(c);
        }
        for (char c: right) {
            output.append(c);
        }

        System.out.println(output);
    }

}
