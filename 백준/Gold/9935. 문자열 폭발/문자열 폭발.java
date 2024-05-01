import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String bombStr = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombStr.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bombStr.length(); j++) {
                    if (stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char i: stack) {
                out.append(i);
            }
            System.out.println(out);
        }
    }

}
