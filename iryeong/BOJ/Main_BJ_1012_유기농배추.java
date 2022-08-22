package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_1012_유기농배추 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int matrix[][] = new int[N][M];
			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				// 배추가 심어져 있으면 1
				matrix[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())] = 1;
			}
			sb.append(check(N, M, matrix) + "\n");
		}
		System.out.println(sb);

	}

	private static int check(int n, int m, int[][] matrix) {
		int flag = 0, worm = 0;
		int checked[][] = new int[n][m];
		Queue<Pair> q = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른
		int[] dy = { 0, 0, -1, 1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 현재 있는 곳에 배추가 있고 아직 체크가 안된 곳이면
				if (matrix[i][j] == 1 && checked[i][j] == 0) {
					// 체크하고 지렁이 수 추가한다음,
					worm++;
					// 사방에 있는지 확인
					q.offer(new Pair(i, j));
					while (!q.isEmpty()) {
						Pair p = q.poll();
						if (p.x >= 0 && p.x < n && p.y >= 0 && p.y < m) {
							if (matrix[p.x][p.y] == 1 && checked[p.x][p.y] == 0) {
								checked[p.x][p.y] = 1;
								for (int k = 0; k < 4; k++) {
									q.offer(new Pair(p.x + dx[k], p.y + dy[k]));
								}
							}
						}
					}
				}
			}
		}
		return worm;

	}

}
