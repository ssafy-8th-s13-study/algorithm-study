package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2078 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int L = 0;
		int R = 0;

		while (!(A == 1 && B == 1)) {
			if (A == 1) {
				R += B - 1;
				break;
			}
			if (B == 1) {
				L += A - 1;
				break;
			}

			if (A > B) {
				L += A / B;
				A = A % B;
			} else if (A < B) {
				R += B / A;
				B = B % A;
			}
		}

		System.out.println(L + " " + R);
	}
}
