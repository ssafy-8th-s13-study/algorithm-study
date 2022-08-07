package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10872 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}

	static int factorial(int n) {
		if (n == 1 || n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}
}
