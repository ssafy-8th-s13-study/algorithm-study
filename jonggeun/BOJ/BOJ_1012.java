package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] board = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			Queue<Integer[]> queue = new LinkedList<>();
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				board[y][x] = 1;
			}

			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (!visited[j][k] && board[j][k] == 1) {
						visited[j][k] = true;
						count++;
						Integer[] first = {j,k};
						queue.add(first);

						while(!queue.isEmpty()) {
							Integer[] curD = queue.poll(); 
							int curY = curD[0];
							int curX = curD[1];
							
							for (int q = 0; q < dy.length; q++) {
								int ny = curY + dy[q];
								int nx = curX + dx[q];
								if (ny >= 0 && ny < N && nx >= 0 && nx < M && board[ny][nx] == 1 && !visited[ny][nx]) {
									visited[ny][nx] = true;
									Integer[] arr = {ny,nx};
									queue.add(arr);
								}
							}
						}
					}
				}
			}
			System.out.println(count);
		}

	}
}
