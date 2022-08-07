package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_17478_재귀함수가뭔가요 {
	public static String str = "____";
	public static int fix = 0;
	public static String output1 = "\"재귀함수가 뭔가요?\"";
	public static String output2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	public static String output3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	public static String output4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	public static String output5 = "라고 답변하였지.";
	public static String output6 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";

	public static void repeat(int N) {
		if (N == 0) {
			System.out.println(output1);
			System.out.println(output6);
			System.out.println(output5);
			return;
		}
		System.out.println(output1);
		System.out.println(output2);
		System.out.println(output3);
		System.out.println(output4);
		output1 = str + output1;
		output2 = str + output2;
		output3 = str + output3;
		output4 = str + output4;
		output5 = str + output5;
		output6 = str + output6;
		repeat(N - 1);
		output5 = output5.substring(4);
		System.out.println(output5);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fix = N;
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		repeat(N);
	}

}
