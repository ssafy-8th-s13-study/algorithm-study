package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int[] spreadDy = { -1, 1, 0, 0 };
	static int[] spreadDx = { 0, 0, -1, 1 };
	static int[] cleanUpDy = { 0, -1, 0, 1 };
	static int[] cleanUpDx = { 1, 0, -1, 0 };
	static int[] cleanDownDy = { 0, 1, 0, -1 };
	static int[] cleanDownDx = { 1, 0, -1, 0 };
	static int R, C, T;
	static int cleanerY;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] == -1) {
					cleanerY = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			clean();
		}

		int sum = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += board[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void clean() {

		int[][] nextBoard = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				nextBoard[i][j] = board[i][j];
			}
		}

		int curY = cleanerY - 1;
		int curX = 1;
		int curD = 0;
		while (true) {
			int ny = curY + cleanUpDy[curD];
			int nx = curX + cleanUpDx[curD];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				curD++;
				continue;
			}

			if (board[ny][nx] == -1)
				break;

			nextBoard[ny][nx] = board[curY][curX];

			curY = ny;
			curX = nx;
		}
		
		nextBoard[cleanerY-1][1] = 0;
		
		curY = cleanerY;
		curX = 1;
		curD = 0;
		while (true) {
			int ny = curY + cleanDownDy[curD];
			int nx = curX + cleanDownDx[curD];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
				curD++;
				continue;
			}

			if (board[ny][nx] == -1)
				break;

			nextBoard[ny][nx] = board[curY][curX];

			curY = ny;
			curX = nx;
		}

		nextBoard[cleanerY][1] = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = nextBoard[i][j];
			}
		}

		
	}

	static void spread() {

		int[][] nextBoard = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				nextBoard[i][j] = board[i][j];
			}
		}

		for (int curY = 0; curY < R; curY++) {
			for (int curX = 0; curX < C; curX++) {

				if (board[curY][curX] == 0 || board[curY][curX] == -1)
					continue;

				for (int k = 0; k < spreadDy.length; k++) {
					int ny = curY + spreadDy[k];
					int nx = curX + spreadDx[k];

					if (ny < 0 || ny >= R || nx < 0 || nx >= C || board[ny][nx] == -1)
						continue;

					nextBoard[ny][nx] += board[curY][curX] / 5;
					nextBoard[curY][curX] -= board[curY][curX] / 5;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				board[i][j] = nextBoard[i][j];
			}
		}

	}
}
