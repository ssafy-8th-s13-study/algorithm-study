package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	
	static int N, max, min;
	static int[] oper;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //수의 개수
		
		numbers = new int[N]; //수 순서 저장 배열
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(tokens.nextToken());
		}
		
		//key는 인덱스로 value는 연산자로 저장
		oper = new int[4]; //+ - x %
		tokens = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(tokens.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		recur(numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void recur(int res, int idx) {
		if(idx == N) { //수 계산 다 함
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper[i]>0) { //0보다 클때만 연산
				oper[i]--;
				
				switch (i) { //연산자를 순서대로 줄여주면서 선택하게함.
				case 0:
					recur(res + numbers[idx], idx+1);
					break;
				case 1:
					recur(res - numbers[idx], idx+1);
					break;
				case 2:
					recur(res * numbers[idx], idx+1);
					break;
				case 3:
					recur(res / numbers[idx], idx+1);
					break;
				}
				oper[i]++;
			}
		}
	}
}
