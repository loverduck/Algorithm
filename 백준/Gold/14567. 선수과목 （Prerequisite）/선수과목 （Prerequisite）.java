import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n + 1];
        ArrayList<Integer> list[] = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[prev].add(next);
            cnt[next]++;
        }

        Queue<int[]> q = new LinkedList<>();
        int result[] = new int[n];

        for(int i = 1; i <= n; i++)
            if(cnt[i] == 0)
                q.offer(new int[] {i, 1});

        while(!q.isEmpty()) {
            int arr[] = q.poll();
            int idx = arr[0];
            int semester = arr[1];
            result[idx - 1] = semester;

            for(int i : list[idx])
                if(--cnt[i] == 0)
                    q.offer(new int[] {i, semester + 1});
        }

        for(int i = 0; i < n; i++)
            output.append(result[i]).append(' ');

        System.out.println(output);
    }
}
