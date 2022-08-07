package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String equation = br.readLine();
		
		int[] value = new int[N];
		for(int i=0; i<N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
				
		Stack<Double> stack = new Stack<Double>();
		for(int i=0; i<equation.length(); i++) {
			char ch = equation.charAt(i);
	        if('A' <= ch && ch <= 'Z') {
	        	double d = value[ch - 'A'];
	        	stack.push(d);
	        } else {
	            double d1 = stack.pop();
	            double d2 = stack.pop();
	            double d3 = 0.0;
	            switch(ch) {
	            	case '+' :
	                	d3 = d2 + d1;
	                	break;
	                case '-' :
	                    d3 = d2 - d1;
	                    break;
	                case '*' :
	                    d3 = d2 * d1;
	                    break;
	                case '/' :
	                    d3 = d2 / d1;
	                    break;
	                }
	            stack.push(d3);
	        }
		}
		System.out.printf("%.2f", stack.pop());
		br.close();
	}
}