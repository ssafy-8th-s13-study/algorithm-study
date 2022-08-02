package com.swea.n1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1217_거듭제곱 {

	static int loop(int num, int count) {
		if(count <=0) {
			return 1;
		}
		return num * loop(num, count-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc<=10; tc++) {
			int tc_num = Integer.parseInt(br.readLine());
			int result = 0;
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			
			int num = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			result = loop(num, count);
			
			System.out.println("#"+tc_num+" "+result);
		}
	}

}
