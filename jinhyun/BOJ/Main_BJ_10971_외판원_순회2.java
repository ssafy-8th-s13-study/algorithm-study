import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원_순회2 {

	static boolean[] isVisited;
	static int[] pick;
	static int[][] W;
	static int N;
	static int ans;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시 수
		isVisited = new boolean[N]; // 방문 체크
		pick = new int[N]; // 선택한 수열(순열)
		W = new int[N][N]; // cost 입력
		ans = Integer.MAX_VALUE; // 최저값 구하기 위해서 최대값으로 초기화
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		
		System.out.println(ans);
		
	}//main
	
	// 순열 생성
	static void perm(int cnt) {
		if(cnt == N) {
			calc();
			return;
		}
		
		for(int i =0; i<N; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			pick[cnt] = i;
			perm(cnt+1);
			isVisited[i]= false;
		}
	}// perm
	
	// cost 계산 및 최저 cost일 때 갱신
	static void calc() {
		int cost = 0;
		for(int i = 0; i<N; i++) {
			if(i==N-1) { // 마지막에 처음 도시 방문
				int temp = W[pick[i]][pick[0]];
				if(temp == 0) return;
				cost += temp;
			}else { // 다음 도시 방문
				int temp = W[pick[i]][pick[i+1]];
				if(temp == 0) return;
				cost += temp;
			}
		}
		
		if(ans > cost) {
			ans = cost;
		}
		
	}// calc
	
}


