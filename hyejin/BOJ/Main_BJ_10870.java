package study;

import java.util.Scanner;

public class Main_BJ_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fibonacci(N));
	}
	
	static int fibonacci(int n) {
		if(n == 1 || n == 0) {
			return n;
		}
		return fibonacci(n-2) + fibonacci(n-1);
	}
	
//	int fibonacci(int n) {
//	    if(n == 0 || n == 1) 
//	        return n;
//	    else {
//	        int result = 0;
//	        int temp1 = 1;
//	        int temp2 = 0;
//	        for(int i = 2; i < n; i++) {
//	            result = temp1 + temp2;
//	            temp2 = temp1;
//	            temp1 = result;
//	        }
//	        return result;
//	    }
}