package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {

	static int N, M;
	static int[][] map;
	static int result;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}

			result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}

			System.out.println("#" + tc + " " + result);

		} // end test case
	}// end main

	static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] v = new boolean[N][N];

		queue.add(new Position(x, y)); // 처음 값 넣음
		v[x][y] = true;

		int house = map[x][y] == 1 ? 1 : 0;
		int k = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int cost = k * k + (k - 1) * (k - 1);

			if (M * house - cost >= 0) { // 비용이 손해가 아닐 때
				result = Math.max(result, house);
			}

			for (int i = 0; i < size; i++) {
				Position position = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = position.x + dr[d];
					int nc = position.y + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {// 범위내이고 방문하지 않았다면
						if (map[nr][nc] == 1) { // 다음 위치가 집이라면
							house++; // 집 개수 증가
						}
						v[nr][nc] = true; // 방문처리
						queue.add(new Position(nr, nc));
					}

				}
			}//end for
			k++; //방범 범위 증가
			
		}//end while
		
	}//end bfs
	
}//end class
