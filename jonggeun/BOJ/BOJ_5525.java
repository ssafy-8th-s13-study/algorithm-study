package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append("IO");
		}
		sb.append("I");

		int count = 0;

		for (int i = 0; i < M - sb.length() + 1; i++) {
			if (S.charAt(i) == 'I') {
				boolean match = true;

				int j = 0;
				for (j = 0; j < sb.length(); j++) {
					if (S.charAt(i + j) != sb.charAt(j)) {
						match = false;
						break;
					}
				}

				if (match) {
					count++;

					while (i + sb.length() + 1 < M) {
						if (S.charAt(i + sb.length()) == 'O'
								&& S.charAt(i + sb.length() + 1) == 'I') {
							count++;
							i = i + 2;
						} else {
							i = i + sb.length() - 1;
							break;
						}
					}
				} else {
					i = i + j - 1;
				}
			}
		}

		System.out.println(count);

	}
}
