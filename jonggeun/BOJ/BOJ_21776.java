package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21776 {
	static int N, C, selected[], nextCard[];
	static int visited[];
	static Card cards[];
	static Set<String> set;
	static Queue<Integer> graph[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new LinkedList<>();
		}

		visited = new int[N];
		selected = new int[C];
		set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int cardNum = Integer.parseInt(st.nextToken());
				graph[i].add(cardNum - 1);
			}

			// 카드 개수 저장
			visited[i] = num;
		}

		cards = new Card[C];
		for (int i = 0; i < C; i++) {
			cards[i] = new Card();
		}

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (str.charAt(0) == 'A')
					cards[i].ops.add(new Integer[] { 0, (int) str.charAt(str.length() - 1) });
				else if (str.charAt(0) == 'D')
					cards[i].ops.add(new Integer[] { 1, str.charAt(str.length() - 1) - '0' });
			}
		}
		perm(0);

		for (String s : set)
			System.out.println(s);
	}

	static void perm(int count) {
		if (count == C) {

			// 사람 순서를 낼 카드 번호로 교체
			int[] cardArr = new int[C];
			for (int i = 0; i < selected.length; i++) {

				// 현재 차례인 사람의 남은 첫 카드
				int num = graph[selected[i]].poll();
				cardArr[i] = num;
				graph[selected[i]].add(num);
			}

			// 빈 문자열로 게임을 시작합니다.
			StringBuilder ans = new StringBuilder();

			// 게임 시작
			for (int i = 0; i < cardArr.length; i++) {

				Card card = cards[cardArr[i]];

				// 카드에 적혀져 있는 연산을 모두 수행하고 턴을 종료합니다.
				for (int k = 0; k < card.ops.size(); k++) {
					Integer[] op = card.ops.get(k);

					// ADD 연산
					if (op[0] == 0) {
						ans.append((char) (int) op[1]);

						// DEL 연산
					} else if (op[0] == 1) {
						// 오류가 발생하면 문자열은 "ERROR"가 되고, 즉시 게임 종료
						try {
							ans.deleteCharAt(op[1]);
						} catch (Exception e) {
							set.add("ERROR");
							return;
						}
					}

				}
			} // 게임 종료

			// 게임이 끝났을 때, 문자열이 빈 문자열이라면, 문자열은 "EMPTY"가 됩니다.
			if (ans.length() == 0)
				ans = new StringBuilder("EMPTY");
			set.add(ans.toString());

			return;
		}

		// 카드가 남아있다면 해당 사람 번호 삽입
		for (int i = 0; i < N; i++) {
			if (visited[i] > 0) {
				visited[i]--;
				selected[count] = i;
				perm(count + 1);
				visited[i]++;
			}
		}
	}

	static class Card {
		ArrayList<Integer[]> ops;

		public Card() {
			this.ops = new ArrayList<>();
		}
	}
}
