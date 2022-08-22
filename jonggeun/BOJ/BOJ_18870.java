package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<c> cList = new ArrayList<>(N);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N;i++) {
			int x = Integer.parseInt(st.nextToken());
			cList.add(new c(x, 0, i));
		}
		
		Collections.sort(cList, new Comparator<c>() {
			
			@Override
			public int compare(c o1, c o2) {
				return o1.X - o2.X;
			}
		});

		int count = 0;
		for(int i=0; i<N; i++) {
			if(i >0 && cList.get(i-1).X == cList.get(i).X) {
				cList.get(i).ans = cList.get(i-1).ans;
			} else {
				cList.get(i).ans = count;
				count++;
			}
		}
		
		Collections.sort(cList, new Comparator<c>() {
			
			@Override
			public int compare(c o1, c o2) {
				return o1.index - o2.index;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			sb.append(cList.get(i).ans).append(" ");
		}
		System.out.println(sb);
		
	}
	
	static class c {
		int X;
		int ans;
		int index;
		
		c(int X, int ans, int index) {
			this.X = X;
			this.ans = ans;
			this.index = index;
		}
	}
}
