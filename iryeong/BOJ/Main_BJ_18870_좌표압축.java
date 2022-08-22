package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_18870_좌표압축 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		HashMap<Integer, Integer> h = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int[] polled = new int[N];
		int[] base = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			h.put(tmp, 0);
			pq.offer(tmp);
			base[i]=tmp;
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			polled[i] = pq.poll();
			if(i>=1 && polled[i]>polled[i-1]) {
				cnt++;
			}
			h.put(polled[i], cnt);
		}
		for(int i=0;i<N;i++) {
			sb.append(h.get(base[i])+" ");
		}
		System.out.println(sb);
	}

}
