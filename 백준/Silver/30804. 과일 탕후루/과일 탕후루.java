import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] fruits;
    static int[] count = new int[10];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        fruits = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int left = 0;
        int right = 0;
        while (left < n) {
            // 현재 위치 과일 확인
            if (right >= n) {
                break;
            }
            count[fruits[right]]++;

            // 종류가 2개 초과라면 left 한칸 이동
            if (kindOfFruit() > 2) {
                count[fruits[left]]--;
                left++;
            }

            if (kindOfFruit() <= 2) {
                result = Math.max(result, right - left + 1);
            }

            right++;
        }

        System.out.println(result);
    }

    public static int kindOfFruit() {
        int result = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] > 0) result++;
        }
        return result;
    }
}
