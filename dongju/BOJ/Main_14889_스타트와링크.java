package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int N, res;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		// 조합 구하고 앞의 true 한팀 false 2개 한팀
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}

		res = Integer.MAX_VALUE;

		comb(0, 0, new boolean[N]);

		System.out.println(res);
	}

	private static void comb(int cnt, int prev, boolean[] v) {
		if (cnt == N / 2) {
			int sub = getMinimum(v);
			res = Math.min(res, sub);
			return;
		}

		for (int i = prev; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				comb(cnt + 1, i+1, v);
				v[i] = false;
			}
		}
	}
	
	private static int getMinimum(boolean[] v) {
		int start = 0;
		int link = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(v[i] && v[j]) {
					start += map[i][j] + map[j][i]; 
				}else if (!v[i] && !v[j]) {
					link += map[i][j] + map[j][i]; 
				}
			}
		}
		
		return Math.abs(start-link);
		
	}

}
