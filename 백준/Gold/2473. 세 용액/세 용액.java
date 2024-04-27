import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static long[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new long[n];
        long[] result = new long[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left, right, mid;
        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            left = i;
            mid = i + 1;
            right = n - 1;
            while (mid < right) {
                long sum = arr[left] + arr[mid] + arr[right];
                if(Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    result[0] = arr[left];
                    result[1] = arr[mid];
                    result[2] = arr[right];
                }

                else if(sum > 0) right--;
                else mid++;
            }
        }

        for (int i = 0; i < 3; i++) {
            out.append(result[i]).append(" ");
        }
        System.out.println(out);
    }

}
