package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_10845 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		
		int last = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine());
			String comd = tokens.nextToken();
			switch(comd) {
			case "push":
				last = Integer.parseInt(tokens.nextToken());
				queue.offer(last);
				break;
			case "pop":
				System.out.println(queue.isEmpty() ? -1 : queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(queue.isEmpty() ? -1 : queue.peek());
				break;
			case "back":
				System.out.println(queue.isEmpty() ? -1 : last);
			}
		}
		br.close();
	}
}