import java.io.*;
import java.util.*;

public class Main {
    static class Combination implements Comparable<Combination> {
        private int chainRingIdx;
        private int backGearIdx;
        private float gearing;

        public Combination(int chainRingIdx, int backGearIdx) {
            this.backGearIdx = backGearIdx;
            this.chainRingIdx = chainRingIdx;
            this.gearing = (float)chainRings[chainRingIdx] / (float)backGears[backGearIdx];
        }

        public int getChainRing() {
            return chainRings[chainRingIdx];
        }

        public int getBackGear() {
            return backGears[backGearIdx];
        }

        @Override
        public String toString() {
            return String.format("%.2f", gearing) + " " + chainRingIdx + " " + backGearIdx;
        }

        @Override
        public int compareTo(Combination o) {
            if (this.gearing == o.gearing) {
                return this.getChainRing() - o.getBackGear();
            }
            return Float.compare(this.gearing, o.gearing);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder out = new StringBuilder();

    static int[] chainRings;
    static int[] backGears;

    static List<Combination> combinations;

    public static void main(String[] args) throws IOException {
        chainRings = new int[4];
        backGears = new int[8];
        combinations = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 4; i++) {
            chainRings[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 8; i++) {
            backGears[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 8; j++) {
                combinations.add(new Combination(i, j));
            }
        }

        Collections.sort(combinations);
        for (Combination c: combinations) {
            out.append(c.toString()).append("\n");
        }
        System.out.println(out);
    }
}
