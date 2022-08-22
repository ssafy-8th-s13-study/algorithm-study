package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3663 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			int countUD = 0;

			// 좌우 이동: 경우 1. 그냥 맨끝까지 가는 경우
			int countLR = str.length() - 1;

			for (int j = 0; j < str.length(); j++) {

				// 1. 상하 이동 횟수 (모두 A 글자로 바꾸는 횟수)
				int c = str.charAt(j) - 'A';
				countUD += Math.min(c, 26 - c);

				// 2. 좌우 이동 횟수

				// 연속된 A 구하기
				int index = j + 1;
				while (index < str.length() && str.charAt(index) == 'A') {
					index++;
				}

				// 좌우 이동: 경우 2. 우 - 좌 - 좌
				// 좌우 이동: 경우 3. 좌 - 우 - 우
				int case2 = (j * 2) + 1 + (str.length() - 1 - index);
				int case3 = 1 + ((str.length() - 1 - index) * 2) + 1 + j;

				// 중 가장 최소 값 구하기
				countLR = Math.min(countLR, Math.min(case2, case3));
			}

			System.out.println(countUD + countLR);
		}
	}

}
