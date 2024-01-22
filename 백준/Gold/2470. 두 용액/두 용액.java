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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n - 1;
        int min = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;
        Arrays.sort(arr);

        while(start < end) {
        	int diff = Math.abs(arr[start] + arr[end]);

        	if(diff < min) {
                min = diff;
                result1 = arr[start];
                result2 = arr[end];
            }

            if(arr[start] + arr[end] <= 0) start++;
            else end--;
        }
        System.out.println(result1 + " " + result2);
    }

}
