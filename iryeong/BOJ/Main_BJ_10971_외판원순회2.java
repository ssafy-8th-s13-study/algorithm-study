package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2 {

	static int N;
	static int ret = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int matrix[][] = new int[N][N];
		boolean visited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(matrix, visited, 0, 0, 0);
		System.out.println(ret);
	}

	private static void dfs(int[][] matrix, boolean[] visited, int j, int sum, int cnt) {
		if (cnt == N && j == 0) {
			if (ret > sum)
				ret = sum;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[j] && matrix[i][j] > 0) {
				visited[j] = true;
				sum += matrix[i][j];
				if (sum <= ret) {
					dfs(matrix, visited, i, sum, cnt + 1);
				}
				visited[j] = false;
				sum -= matrix[i][j];
			}
		}
	}

}
