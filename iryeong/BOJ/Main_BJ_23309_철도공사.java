package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_23309_철도공사 {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int prev[] = new int[1000001];
		int next[] = new int[1000001];
		int tmp;
		st = new StringTokenizer(br.readLine());
		int tmpPrev = Integer.parseInt(st.nextToken());
		int start = tmpPrev;
		for(int i=1;i<N;i++){
			tmp = Integer.parseInt(st.nextToken());
			next[tmpPrev] = tmp;
			prev[tmp] = tmpPrev;
			tmpPrev = tmp;
		}
		prev[start] = tmpPrev;
		next[tmpPrev] = start;
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			String command = st3.nextToken();
			int p = Integer.parseInt(st3.nextToken());
			int q, m;
			if (command.equals("BN")) {
				q = Integer.parseInt(st3.nextToken());
				sb.append(next[p] + "\n");
				next[q] = next[p];
				prev[q] = p;
				prev[next[p]] = q;
				next[p] = q;
			} else if (command.equals("BP")) {
				q = Integer.parseInt(st3.nextToken());
				sb.append(prev[p] + "\n");
				next[q] = p;
				prev[q] = prev[p];
				next[prev[p]] = q;
				prev[p] = q;
			} else if (command.equals("CN")) {
				sb.append(next[p] + "\n");
				m = next[next[p]];
				next[p] = m;
				prev[m] = p;
			} else {
				sb.append(prev[p] + "\n");
				m = prev[prev[p]];
				prev[p] = m;
				next[m] = p;
			}
		}
		System.out.println(sb);
	}
}
