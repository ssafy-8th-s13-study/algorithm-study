package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static void hanoi(int N, int start, int temp, int end) {
		if(N==0)
			return;
		
		// N-1개의 원판을 시작 기둥에서 임시 기둥으로 옮긴다
		hanoi(N-1, start, end, temp);
		
		// N번째 원판을 시작 기둥에서 목적 기둥으로 옮긴다
		sb.append(start + " " + end + "\n");
		count++;
		
		// N-1개의 원판을 임시 기둥에서 목적 기둥으로 옮긴다
		hanoi(N-1, temp, start, end);
	}
}
