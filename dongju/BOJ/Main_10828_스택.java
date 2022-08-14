//[BOJ] 10828. 스택

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {
	static final String PUSH = "push";
	static final String POP = "pop";
	static final String SIZE = "size";
	static final String EMPTY = "empty";
	static final String TOP = "top";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case PUSH:
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case POP:
				if(stack.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(stack.pop());
				break;
			case SIZE:
				System.out.println(stack.size());
				break;
			case EMPTY:
				int res = stack.isEmpty() ? 1 : 0;
				System.out.println(res);
				break;
			case TOP:
				if(stack.isEmpty()) {
					System.out.println(-1);
					break;
				}
				System.out.println(stack.peek());
				break;
			}
		}
	}
}
