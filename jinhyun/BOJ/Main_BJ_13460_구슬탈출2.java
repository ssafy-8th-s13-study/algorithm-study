import java.io.*;
import java.util.*;

class Ball {
	int x;
	int y;
	int count;

	public Ball(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main_BJ_13460_구슬탈출2 {

	static int N, M, ans;
	static char[][] map;
	static Ball red, blue;
	static boolean[][][][] visited;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j);
				if (map[i][j] == 'R') {
					red = new Ball(i, j, 0);
				} else if (map[i][j] == 'B') {
					blue = new Ball(i, j, 0);
				}
			}
		}
		
		ans = -1;
		bfs(red, blue);
		System.out.println(ans);
	}


	static void bfs(Ball r_ball, Ball b_ball) {
		Queue<Ball> redQ = new ArrayDeque<>();
		Queue<Ball> blueQ = new ArrayDeque<>();
		
		// 처음 위치 방문 처리
		visited[r_ball.x][r_ball.y][b_ball.x][b_ball.y] = true;

		redQ.offer(r_ball);
		blueQ.offer(b_ball);

		while (!redQ.isEmpty() && !blueQ.isEmpty()) {
			Ball nr_ball = redQ.poll();
			Ball nb_ball = blueQ.poll();

			// 10회 초과시 종료
			if (nr_ball.count > 10) {
				ans = -1;
				return;
			}

			// 파란공이 구멍에 도착한 경우 : 실패
			if (map[nb_ball.x][nb_ball.y] == 'O') {
				continue;
			}

			// 빨간공만 구멍에 도착한 경우 : 성공
			if (map[nr_ball.x][nr_ball.y] == 'O') {
				ans = nr_ball.count;
				return;
			}

			// 상하좌우로 기울이기
			for (int d = 0; d < 4; d++) {
				
				// 파란공이 이동가능한 지점까지 이동
				int bx = nb_ball.x;
				int by = nb_ball.y;
				while (true) {
					bx += dx[d];
					by += dy[d];
					if (map[bx][by] == 'O') // 구멍 도착
						break;
					else if (map[bx][by] == '#') { // 벽에 도착 (도착하기 이전 칸으로 수정)
						bx -= dx[d];
						by -= dy[d];
						break;
					}
				}

				// 빨간공이 이동가능한 지점까지 이동
				int rx = nr_ball.x;
				int ry = nr_ball.y;
				while (true) {
					rx += dx[d];
					ry += dy[d];
					// 빠져나간 경우
					if (map[rx][ry] == 'O')
						break;
					// 벽을 만난 경우
					else if (map[rx][ry] == '#') {
						rx -= dx[d];
						ry -= dy[d];
						break;
					}
				}

				if (bx == rx && by == ry && map[rx][ry] != 'O') { // 도착 지점이 동일하지만 구멍이 아닌 경우(앞서 출발한 공이 앞에 위치해야한다.)
					if(d == 0) {//상
						if(nr_ball.x < nb_ball.x) {
							bx -=dx[d];
							by -=dy[d];
						}else {
							rx -=dx[d];
							ry -=dy[d];
						}
					}
					if(d == 1) {//하
						if(nr_ball.x > nb_ball.x) {  
							bx -=dx[d];
							by -=dy[d];
						}else {
							rx -=dx[d];
							ry -=dy[d];
						}
					}
					if(d == 2) {//좌
						if(nr_ball.y < nb_ball.y) { 
							bx -=dx[d];
							by -=dy[d];
						}else {
							rx -=dx[d];
							ry -=dy[d];
						}
					}
					if(d == 3) {//우
						if(nr_ball.y > nb_ball.y) { 
							bx -=dx[d];
							by -=dy[d];
						}else {
							rx -=dx[d];
							ry -=dy[d];
						}
					}
				}

				// 다음 좌표 방문 처리 및 큐에 추가
				if (!visited[rx][ry][bx][by]) {
					// 방문처리
					visited[rx][ry][bx][by] = true;
					
					// 큐에 추가
					redQ.offer(new Ball(rx, ry, nr_ball.count + 1));
					blueQ.offer(new Ball(bx, by, nb_ball.count + 1));
				}
			}

		}
	}

}