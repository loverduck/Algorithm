import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] isPrime;
    static List<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        getPrime(n);

        int result = 0;
        int start = 0, end = 0, sum = 2;
        while(start <= end && end < prime.size()) {
            if(n > sum) {
                end++;
                if(end >= prime.size()) break;
                sum += prime.get(end);
            } else if (n < sum) {
                sum -= prime.get(start++);
            } else {
                result++;
                sum -= prime.get(start++);
            }
        }

        System.out.println(result);
    }


    public static void getPrime(int num) {
        isPrime = new boolean[num + 1];

        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i * i <= num; i++){
            if(!isPrime[i]) {
                for(int j = i * i; j <= num; j += i) isPrime[j] = true;
            }
        }

        for (int i = 2; i <= num ; i++) {
            if (!isPrime[i]) prime.add(i);
        }

    }

}
