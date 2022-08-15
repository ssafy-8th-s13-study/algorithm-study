package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23309 {
	static int[] prev = new int[1000001];
	static int[] next = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		int v = Integer.parseInt(st.nextToken());
		prev[v] = v;
		next[v] = v;

		for (int i = 1; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			add(v, value);
			v = value;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			int curValue = Integer.parseInt(st.nextToken());

			if (command.equals("BN")) {

				int nextValue = next[curValue];
				int addValue = Integer.parseInt(st.nextToken());

				sb.append(nextValue).append("\n");
				add(curValue, addValue);

			} else if (command.equals("BP")) {
				int prevValue = prev[curValue];
				int addValue = Integer.parseInt(st.nextToken());

				sb.append(prevValue).append("\n");
				add(prevValue, addValue);

			} else if (command.equals("CN")) {
				int removeValue = next[curValue];
				remove(removeValue);
				sb.append(removeValue).append("\n");

			} else if (command.equals("CP")) {
				int removeValue = prev[curValue];
				remove(removeValue);
				sb.append(removeValue).append("\n");

			}

		}
		System.out.println(sb);
	}

	static void add(int curValue, int addValue) {

		prev[addValue] = curValue;
		next[addValue] = next[curValue];

		next[curValue] = addValue;
		prev[next[addValue]] = addValue;
	}

	static void remove(int removeValue) {
		next[prev[removeValue]] = next[removeValue];
		prev[next[removeValue]] = prev[removeValue];

	}

}
