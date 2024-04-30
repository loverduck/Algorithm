import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] parent;
    static boolean[] people;
    static boolean[] party;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        people = new boolean[n + 1];
        parent = new int[n + 1];
        party = new boolean[m];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowTrueCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowTrueCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            people[num] = true;
        }

        List<List<Integer>> partyPeople = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            partyPeople.add(new ArrayList<>());
            partyPeople.get(i).add(Integer.parseInt(st.nextToken()));
            for (int j = 1; j < num; j++) {
                partyPeople.get(i).add(Integer.parseInt(st.nextToken()));
                union(partyPeople.get(i).get(j - 1), partyPeople.get(i).get(j));
            }
        }

        for (int i = 1; i <= n; i++) {
            if(people[i]) {
                int p = find(i);
                people[p] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int j = 0; j < partyPeople.get(i).size(); j++) {
                int p = find(partyPeople.get(i).get(j));
                if (people[p]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    public static int find(int n) {
        if(parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(parent[p1] > parent[p2]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }
}
