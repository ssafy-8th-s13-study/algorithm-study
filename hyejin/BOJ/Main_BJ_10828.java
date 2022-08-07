package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_10828 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			String comd = tokens.nextToken();
			switch(comd) {
			case "push":
				stack.push(Integer.parseInt(tokens.nextToken()));
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "top":
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				break;
			case "pop":
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			case "empty":
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}
		}
		br.close();
	}
}