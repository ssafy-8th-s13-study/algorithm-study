package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_11729_하노이탑이동순서 {

	public static StringBuilder sb = new StringBuilder();
	public static int count = 0;

	public static void hanoi(int start, int temp, int end, int N) {

		if (N == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			count++;
			return;
		}
		hanoi(start, end, temp, N - 1);
		sb.append(start).append(" ").append(end).append("\n");
		count++;
		hanoi(temp, start, end, N - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(1, 2, 3, N);
		System.out.println(count);
		System.out.println(sb);
	}

}
