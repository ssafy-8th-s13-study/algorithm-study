package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2078_무한이진트리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int countL = 0;
		int countR = 0;

		while (L != 1 || R != 1) {
			if (L > R) {
				countL++;
				L = L - R;
			} else if (R > L) {
				countR++;
				R = R - L;
			}
		}
		System.out.println(countL + " " + countR);
	}

}
