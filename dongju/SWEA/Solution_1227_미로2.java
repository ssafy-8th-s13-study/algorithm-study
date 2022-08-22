import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int[][] arr = new int[100][100];
	static int startX, startY, res;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static void move(int x, int y) {
		arr[x][y] = 7; //방문한 곳이라면 바꿔줌

		for (int d = 0; d < 4; d++) { // 4방탐색
			int nx = x + dr[d];
			int ny = y + dc[d];

			//범위 벗어나면 진행 안함
			if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100)
				continue;

			if (arr[nx][ny] == 3) { // 이동해서 3이라면 탐색 종료
				res = 1;
				return;
			}
			if (arr[nx][ny] == 0) {
				move(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input (8).txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테스트케이스
			
			for (int i = 0; i < 100; i++) { // 배열 입력
				String temp = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = temp.charAt(j) - '0';
					if (arr[i][j] == 2) { // 시작위치 저장
						startX = i;
						startY = j;
					}
				}
			} // 배열입력 종료
			res = 0;
			move(startX, startY);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		} // end test case
		System.out.print(sb);
		br.close();
	}
}
