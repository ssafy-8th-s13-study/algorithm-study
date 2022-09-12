package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	// (1) 비 내리는 양은 1부터 최대높이만큼 설정
	// (2) 비 내리는 양만큼 잠기는 복사배열 설정
	// (3) dfs로 인접영역 조사
	// (4) 최대영역 설정

	static int N, maxH = 0, res = Integer.MIN_VALUE; //영역크기, 최대높이, 결과값
	static int[][] map; //원본배열
	static int[][] copy; //연산에 사용할 복사배열
	static boolean[][] visited; //방문체크

	static int[] dr = { -1, 1, 0, 0 }; //4방탐색
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if (map[i][j] > maxH) {
					maxH = map[i][j]; // 최대 높이 설정
				}
			}
		} // 입력완료

		
		// 0부터 최대높이까지 영역 조사
		for (int i = 0; i <= maxH; i++) {
			
			int area = 0; //구역 초기화
			
			copyMap(); // 높이 조사할때마다 새로 배열 복사해줌
			
			notSafe(i); // 잠긴 영역을 0으로 만듦

			visited = new boolean[N][N]; // 방문체크 배열
			
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					if(copy[x][y]!=0 && !visited[x][y]) { //잠기지 않았고 방문하지 않음
						dfs(x, y);
						area++; //한번 갔다올때마다 영역이 생김
					}
					
				}
			}
			
			res = Math.max(res, area); //최대 영역 설정
			
		}//높이별로 영역 조사 완료
		
		System.out.println(res);
		
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true; //방문체크

		for (int d = 0; d < 4; d++) { //4방탐색
			int nx = x + dr[d];
			int ny = y + dc[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 해당 범위 내에 있음
				if (!visited[nx][ny] && copy[nx][ny] != 0) { // 방문하지 않았고 갈 수 있음
					dfs(nx, ny); //다음 위치 조사
				}
			}
		}
	}

	private static void notSafe(int h) { //물에 잠긴 영역
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] <= h) {
					copy[i][j] = 0; // 잠긴 지역은 0으로 만들어줌
				}
			}
		}
	}

	private static void copyMap() { //원본 배열 복사
		copy = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

}
