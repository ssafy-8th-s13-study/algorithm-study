package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		int[][] board = new int[N][M];
		int[][] day = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		boolean ripen = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] == 1)
					queue.add(new Integer[] { i, j });

				if (board[i][j] == 0)
					ripen = false;
			}
		}
		if (ripen) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Integer[] curP = queue.poll();
			int curY = curP[0];
			int curX = curP[1];

			for (int k = 0; k < dy.length; k++) {
				int ny = curY + dy[k];
				int nx = curX + dx[k];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
					continue;

				if (board[ny][nx] == 1) {
					queue.add(new Integer[] { ny, nx });
				}

				if (board[ny][nx] == 0) {
					board[ny][nx] = 1;
					day[ny][nx] = day[curY][curX] + 1;
					queue.add(new Integer[] { ny, nx });
				}

				visited[ny][nx] = true;
			}
		}

		int maxDay = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if (day[i][j] > maxDay)
					maxDay = day[i][j];
			}
		}

		System.out.println(maxDay);
	}
}
