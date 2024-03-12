import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[][] rooms;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());

        long maxHp = 0;
        long curHp = 0;

        rooms = new long[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());

            if (t == 1) {
                long turn = hp % atk == 0 ? hp / atk - 1 : hp / atk;
                curHp += attack * turn;
                maxHp = Math.max(maxHp, curHp);
            } else {
                atk += attack;
                curHp = Math.max(curHp - hp, 0);
            }
        }
        System.out.println(maxHp + 1);
    }
}
