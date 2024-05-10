import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        double[] score = new double[n];
        double avg;
        double max = 0, sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n;i++) {
            score[i] = Double.parseDouble(st.nextToken());
            if(score[i] > max)
                max = score[i];
        }

        for (int i = 0; i < score.length; i++) {
            score[i] = (score[i] / max) * 100;
            sum += score[i];
        }
        avg = sum / n;
        System.out.println(avg);
    }
}
