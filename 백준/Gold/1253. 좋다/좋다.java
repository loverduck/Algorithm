
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int result = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;

            while (true) {
                if(start == i) start++;
                else if(end == i) end--;

                if(start >= end) break;

                if(arr[start] + arr[end] > arr[i]) end--;
                else if(arr[start] + arr[end] < arr[i]) start++;
                else {
                    result++;
                    break;
                }
            }

        }
        System.out.println(result);
    }
}
