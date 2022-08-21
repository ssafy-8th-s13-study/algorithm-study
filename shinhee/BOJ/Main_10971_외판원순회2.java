import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	
	static int [][] map;	// 경로 가중치를 저장하는 배열
	static int result;		// 최종 결과 값
	
	static void perm(int [] arr, boolean [] visited, int cnt, int N) {
		if(cnt==N) {
			result = Math.min(getMinPath(arr),result);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]		= true;
				arr[cnt]		= i+1;				
				perm(arr, visited, cnt+1, N);
				visited[i]		= false;
			}
		}
		
	}
	
	// 경로에 따른 가중치를 더하는 함수
	static int getMinPath(int [] arr) {
		
		int p_len = 0;
		
		for(int i=1;i<arr.length;i++) {
			if(map[arr[i-1]][arr[i]]==0) {
				return Integer.MAX_VALUE;
			}
			p_len +=map[arr[i-1]][arr[i]];
		}
		if(map[arr[arr.length-1]][arr[0]]==0) return Integer.MAX_VALUE;

		p_len+=map[arr[arr.length-1]][arr[0]];	// 다시 돌아가는 것 
		
		return p_len;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [N+1][N+1];
		int [] path = new int [N];
		boolean [] visited = new boolean [N];
		result=Integer.MAX_VALUE;
		
		// map 입력
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				map[j][i] = Integer.parseInt(st.nextToken());
			}		
		}
		
		// 경로를 방문한는 순서를 저장하는 배열
		for(int i=0;i<N;i++) {
			path[i]= i+1;
		}
		
		// 순열을 사용해서, 경로를 만들고, 그 경로에 따른 가중치값을 더해서 최솟값을 구해보자.
		perm(path,visited,0,N);
		System.out.println(result);
	}

}
