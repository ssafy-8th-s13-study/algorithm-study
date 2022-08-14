package study;

import java.util.Scanner;

public class Main_BJ_10872 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
	}
	
	static int factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		n = n * factorial(n-1);
		return n;
	}
}