//[SWEA] 1204 최빈수 구하기

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			int tcIdx = sc.nextInt(); // tesc_case number
			int[] scores = new int[101]; //0점부터 100점까지 저장할 수 있는 배열
			int max = 0;
			int result_score = 0;
			
			for(int i = 0; i<1000; i++) {
				int score = sc.nextInt();
				scores[score]++;
			}
			
			for(int i = 0; i<scores.length; i++) {
				if (max <= scores[i]) {
					max = scores[i];
					result_score = i;
				}
			}
			
			System.out.printf("#%d %d", tc, result_score);
			System.out.println();
			
		}
		sc.close();
	}
}