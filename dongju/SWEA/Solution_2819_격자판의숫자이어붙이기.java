import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2819_격자판의숫자이어붙이기 {

	static String[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			map = new String[4][4];
			set = new HashSet<>();

			// 맵 입력
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			//모든 위치 탐색
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, "" + map[i][j], 0);
				}
			}

			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		} // end test case

		
		System.out.println(sb);
	}// end main

	private static void dfs(int x, int y, String num, int cnt) {
		if (cnt == 6) { //처음에 한글자 선택되어 나머지 6글자만 선택
			set.add(num); //중복 방지를 위해 set 사용
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];

			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				dfs(nx, ny, num + map[nx][ny], cnt + 1);
			}
		}
	}

}
