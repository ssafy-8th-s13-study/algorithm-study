//[BOJ] 1935. 후위 표기식2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935_후위표기식2 {
	static Stack<Double> stack;	//소수점 계산을 위해 double

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		String op = br.readLine();	//명령어 읽을 문자열
		double[] num = new double[n]; //숫자 저장할 배열
		for (int i = 0; i < n; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		for(int i=0; i<op.length(); i++) {
			if(op.charAt(i) >= 'A' && op.charAt(i) <= 'Z') { //읽은 문자열이 A~Z 범위라면
				stack.push(num[op.charAt(i)-'A']);	//A~Z의 순서를 1~n으로 변환하여 숫자 배열 인덱스로 접근
			}else {
				if(!stack.isEmpty()) {
					double a = stack.pop();
					double b = stack.pop();
					//연산 후 스택에 저장. b가 먼저 계산되어야 함
					switch (op.charAt(i)) {
					case '+':
						stack.push(b+a);
						break;
					case '-':
						stack.push(b-a);
						break;
					case '*':
						stack.push(b*a);
						break;
					case '/':
						stack.push(b/a);
						break;
					}
				}
			}
		}
		System.out.printf("%.2f\n", stack.pop());
	}
}
