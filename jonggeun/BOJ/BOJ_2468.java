package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		int ans = 1;
		int minH = 100;
		int maxH = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (minH > board[i][j])
					minH = board[i][j];
				if (maxH < board[i][j])
					maxH = board[i][j];

			}
		}

		for (int i = minH; i <= maxH; i++) {
			boolean[][] visited = new boolean[N][N];
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && board[j][k] > i) {
						cnt++;
						Queue<Integer[]> queue = new LinkedList<Integer[]>();
						queue.add(new Integer[] { j, k });
						visited[j][k] = true;

						while (!queue.isEmpty()) {
							Integer[] cur = queue.poll();

							for (int q = 0; q < dy.length; q++) {
								int ny = cur[0] + dy[q];
								int nx = cur[1] + dx[q];

								if (ny < 0 || ny >= N || nx < 0 || nx >= N)
									continue;

								if (!visited[ny][nx] && board[ny][nx] > i) {
									visited[ny][nx] = true;
									queue.add(new Integer[] { ny, nx });
								}
							}
						}
					}
				}
			}
			if (cnt > ans)
				ans = cnt;
		}

		System.out.println(ans);

	}
}
