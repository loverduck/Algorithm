import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int n, m;
    static int[] sequence1, sequence2;
    static List<Integer> subsequence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        sequence1 = new int[n];

        int maxNum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence1[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, sequence1[i]);
        }

        m = Integer.parseInt(br.readLine());
        sequence2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sequence2[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);

        out.append(subsequence.size()).append("\n");
        for (int i = 0; i < subsequence.size(); i++) {
            out.append(subsequence.get(i)).append(" ");
        }
        System.out.println(out);
    }

    public static void find(int idx1, int idx2) {
        if (idx1 >= n || idx2 >= m) return;

        int maxNum = findMax(idx1, idx2);
        if (maxNum == 0) return;

        int maxIdx1 = 0;
        int maxIdx2 = 0;

        for (int i = idx1; i < n; i++) {
            if (sequence1[i] == maxNum) {
                maxIdx1 = i;
                break;
            }
        }

        for (int i = idx2; i < m; i++) {
            if (sequence2[i] == maxNum) {
                maxIdx2 = i;
                break;
            }
        }

        subsequence.add(maxNum);

        find(maxIdx1 + 1, maxIdx2 + 1);
    }

    public static int findMax(int idx1, int idx2) {
        int[] sortSeq1 = Arrays.copyOfRange(sequence1, idx1, sequence1.length);
        int[] sortSeq2 = Arrays.copyOfRange(sequence2, idx2, sequence2.length);
        Arrays.sort(sortSeq1);
        Arrays.sort(sortSeq2);

        int maxNum = 0;
        for (int i = sortSeq1.length - 1; i >= 0; i--) {
            for (int j = sortSeq2.length - 1; j >= 0; j--) {
                if (sortSeq1[i] == sortSeq2[j]) {
                    maxNum = sortSeq1[i];
                    return maxNum;
                }
            }
        }
        return maxNum;
    }
}
