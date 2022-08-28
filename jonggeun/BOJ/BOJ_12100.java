package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, board[][], max;
	static boolean combined[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		combined = new boolean[N][N];
		int curMax = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] > curMax)
					curMax = board[i][j];
			}
		}

		max = curMax;
		dfs(0);
		System.out.println(max);
	}

	static void dfs(int count) {

		if (count == 5) {
			return;
		}
		
		// 상하좌우 수행
		for (int i = 0; i < dy.length; i++) {

			combined = new boolean[N][N];
			int[][] tmp = new int[N][N];

			// 임시 맵 생성
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[j][k] = board[j][k];
				}
			}

			// 상, 좌
			if (i == 0 || i == 2) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						move(tmp, combined, i, j, k);
					}
				}
			}

			// 하, 우
			if (i == 1 || i == 3) {
				for (int j = N - 1; j >= 0; j--) {
					for (int k = N - 1; k >= 0; k--) {
						move(tmp, combined, i, j, k);
					}
				}
			}
			
			// 다음 dfs
			dfs(count + 1);

			// 판 원상 복구
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					board[j][k] = tmp[j][k];
				}
			}
		}
	}

	static void move(int[][] tmp, boolean[][] combind, int i, int j, int k) {

		int ny = j + dy[i];
		int nx = k + dx[i];
		while (true) {

			// 벽에 닿았거나, 합칠 수 없는 다른 블록과 만났을 경우(크기가 다름, 이미 합쳐짐)
			// 이동 불가능 -> 다음 칸으로 이동
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				return;
			if (board[ny][nx] != 0 && board[ny][nx] != board[ny-dy[i]][nx-dx[i]])
				return;
			if (combined[ny][nx] || combined[ny-dy[i]][nx-dx[i]])
				return;

			// 이동 가능하다면
			// 1. 다음 블럭이 0이라면
			if (board[ny][nx] == 0) {
				// 다음 블럭으로 밀고 현재 블럭은 0
				board[ny][nx] = board[ny - dy[i]][nx - dx[i]];
				combined[ny][nx] = combined[ny - dy[i]][nx - dx[i]];
				
				board[ny - dy[i]][nx - dx[i]] = 0;
				combined[ny - dy[i]][nx - dx[i]] = false;
			}

			// 2. 다음 블럭이 합칠 수 있는 블록일 경우
			else {
				// 다음 블럭에 현재 블럭을 더하고 현재 블럭은 0
				board[ny][nx] += board[ny - dy[i]][nx - dx[i]];
				if(board[ny][nx] > max)
					max = board[ny][nx];
				board[ny - dy[i]][nx - dx[i]] = 0;
				combined[ny][nx] = true;
			}

			ny = ny + dy[i];
			nx = nx + dx[i];
		}
	}
}
