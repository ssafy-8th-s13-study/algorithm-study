package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971 {
	static int INF = 87_654_321;
	static int N;
	static int[][] graph, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N][(1 << N)];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(dfs(0, 1));
	}

	static int dfs(int current, int visited) {

		if (visited == (1 << N) - 1) {
			if (graph[current][0] == 0)
				return INF;

			return graph[current][0];
		}

		if (dp[current][visited] != INF)
			return dp[current][visited];

		for (int next = 0; next < N; next++) {
			if ((visited & (1 << next)) == 0 && graph[current][next] != 0) {
				dp[current][visited] = Math.min(dp[current][visited],
						dfs(next, visited | (1 << next)) + graph[current][next]);
			}
		}
		return dp[current][visited];
	}
}
