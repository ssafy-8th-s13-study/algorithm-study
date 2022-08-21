import java.util.Arrays;
import java.util.Scanner;

public class Main_18429_근손실 {
	static int N,K,result;
	static void perm(int [] arr, boolean [] visited, int cnt,  int limit) {
		if(limit<500) return;
		if(cnt==N) {
			result+=1;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]		= true;				
				perm(arr, visited, cnt+1, limit-K+arr[i]);
				visited[i]		= false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		int [] w 	= new int [N];
		boolean [] visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			w[i] = sc.nextInt();
		}
		result=0;
		perm(w,visited,0,500);
		System.out.println(result);
		
	}

}
