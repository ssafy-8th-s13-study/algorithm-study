package study;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_BJ_2504 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		String in = sc.next();

		int mul = 1;
        int result = 0;
        
        calculation:
        for (int i=0; i<in.length(); i++) {
            switch (in.charAt(i)) {
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;
                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break calculation;
                    } else if (in.charAt(i-1) == '(') {
                    	result += mul;
                    }
                    stack.pop();
                    mul /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                    	result = 0;
                    	break calculation;
                    } else if (in.charAt(i-1) == '[') {
                    	result += mul;
                    }
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }
        if(!stack.isEmpty()) {
        	result = 0;
        }
        System.out.println(result);
        sc.close();
	}
}