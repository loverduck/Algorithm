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

        rooms = new long[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rooms[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long left = 0;
        long right = ((long)2 << 62) - 1;
        while(left <= right) {
            long mid = (left + right) / 2;
            long satk = atk;
            long hp = mid;
            boolean alive = true;
            for(int i=0; i<n; i++) {
                if(rooms[i][0] == 1) {
                    if(rooms[i][2] % satk == 0) hp -= ((rooms[i][2] / satk) - 1) * rooms[i][1];
                    else hp -= (rooms[i][2] / satk) * rooms[i][1];
                    if(hp <= 0) {
                        alive = false;
                        break;
                    }
                } else {
                    hp += rooms[i][2];
                    hp = hp > mid ? mid : hp;
                    satk += rooms[i][1];
                }
            }
            if(!alive) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }
}
