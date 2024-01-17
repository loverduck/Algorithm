import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static List<int[]> brackets;
    static Set<String> result;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        String expression = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        brackets = new ArrayList<>();
        check = new boolean[expression.length()];
        result = new TreeSet<>();

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '(') stack.push(i);
            else if (expression.charAt(i) == ')') {
                brackets.add(new int[] {stack.pop(), i});
            }
        }

        comb(0, expression.toCharArray());

        Iterator<String> iterator = result.iterator();
        while(iterator.hasNext()) {
            output.append(iterator.next()).append("\n");
        }

        System.out.println(output);
    }

    static void comb(int depth, char[] str) {
        if(depth == brackets.size()) {
            boolean f = false;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length; i++) {
                if(!check[i]) {
                    sb.append(str[i]);
                } else f = true;
            }
            if(f) {
                result.add(sb.toString());
            }
            return;
        }

        comb(depth + 1, str);

        int[] bracket = brackets.get(depth);
        check[bracket[0]] = true;
        check[bracket[1]] = true;
        comb(depth+1, str);
        check[bracket[0]] = false;
        check[bracket[1]] = false;
    }
}
