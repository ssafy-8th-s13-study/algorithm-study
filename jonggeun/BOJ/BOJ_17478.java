package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17478 {
	static String question = "\"재귀함수가 뭔가요?\"\n";
	static String[] questionRepeat = new String[] { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" };
	static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String answerRepeat = "라고 답변하였지.\n";
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		printRecursion(N, 0);
		System.out.println(sb);
	}

	static void printRecursion(int N, int count) {
		String underBar = "";
		for (int i = 0; i < count; i++) {
			underBar += "____";
		}

		sb.append(underBar + question);		
		if (count < N) {
			for (String s : questionRepeat) {
				sb.append(underBar + s);
			}
			printRecursion(N, ++count);
		} else sb.append(underBar + answer);
		
		sb.append(underBar + answerRepeat);
		return;
	}
}
