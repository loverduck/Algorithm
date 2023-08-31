import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 17 * 1000000 + 1;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static int n, end, cost[][], dp[][];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		end = (1 << n) - 1;
		cost = new int[n][n];
		dp = new int[n][1 << n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(TSP(0, 1));

	}
	
	static int TSP(int now, int visited) {
		// 끝까지 다 방문했을 경우
		if(visited == end) {
			// 시작 지점과 현재 노드가 연결되어 있다면
			if(cost[now][0] > 0) {
				return cost[now][0];
			}
			return INF;
		}
		
		// 이미 계산한 값이 존재한다면
		if(dp[now][visited] != 0) return dp[now][visited];
		dp[now][visited] = INF;
		
		// 다음 방문할 노드 찾기
		for(int i = 0; i < n; i++) {
			// 연결이 안되어있거나 이미 방문한 노드 제외하기
			if(cost[now][i] == 0 || (visited & (1 << i)) > 0) continue;
			// 현재 저장된 값과 i를 방문했을 경우의 비용 비교후 최소값 저장
			dp[now][visited] = Math.min(dp[now][visited], cost[now][i] + TSP(i, visited | 1 << i));
		}
		return dp[now][visited];
	}

}