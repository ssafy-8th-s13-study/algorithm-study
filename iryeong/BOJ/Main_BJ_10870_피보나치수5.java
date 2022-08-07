package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10870_피보나치수5 {

	public static int pibonacci(int n) {
		if (n == 0 || n == 1)
			return n;
		return pibonacci(n - 1) + pibonacci(n - 2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(pibonacci(num));
	}

}