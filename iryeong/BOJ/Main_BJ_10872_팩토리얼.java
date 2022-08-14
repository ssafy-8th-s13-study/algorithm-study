package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10872_팩토리얼 {

	public static int fac(int N) {
		if (N == 0)
			return 1;
		if (N == 1)
			return 1;
		return fac(N - 1) * N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fac(N));
	}
}