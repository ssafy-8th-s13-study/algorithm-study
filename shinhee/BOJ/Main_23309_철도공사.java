import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_23309_철도공사 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());		// 역의 개수
		int M = Integer.parseInt(st.nextToken());		// 공사 횟수

		int [] prev_stop = new int [1000001];
		int [] next_stop = new int [1000001];
		int [] stations	= new int [N];
		

		
		int before_stop = 0;
		// prev_stop, next_stop 생성
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			stations[i] = Integer.parseInt(st.nextToken());
			int n = stations[i];
						
			if(i==0) {
			}
			else if (i==N-1) {
				prev_stop[n] = before_stop;		
				next_stop[n] = stations[0];		// 마지막 stop의 next : 첫번째 stop
				prev_stop[stations[0]]	=	n; 	// 첫번째 stop의 이전 역
				next_stop[before_stop] 	= n;
			}
			else {
				prev_stop[n] 			= before_stop;
				next_stop[before_stop] 	= n;
			}
			before_stop = stations[i];
		}

		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			if(cmd.charAt(0)=='B') {
				int new_stop	= Integer.parseInt(st.nextToken());
				// BN : 고유 번호 i를 가진 역의 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
				if(cmd.charAt(1)=='N') { 		// 다음역
					prev_stop[next_stop[n]] = new_stop;
					next_stop[new_stop]	= next_stop[n];		// 1. 새로운 역의 다음역  <- 원래 역의 다음역
					prev_stop[new_stop]	= n;				// 2. 새로운 역의 이전 역 <- 원래 역
					next_stop[n]			= new_stop; 	// 3. 다음 역으로 추가
					sb.append(next_stop[new_stop]).append('\n');
					}
				// BP : 고유 번호 i를 가진 역의 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
				else if(cmd.charAt(1)=='P') { 	// 이전역
					next_stop[prev_stop[n]]		= new_stop;		// 1. 원래 역의 이전 역의 다음 역 <- 새로운 역
					prev_stop[new_stop]			= prev_stop[n]; // 2. 새로운 역의 이전 역 <- 원래 역의 이전 역
					next_stop[new_stop]			= n;			// 3. 새로운 역의 다음 역 <- 원래 역
					prev_stop[n]				= new_stop;		// 4. 원래 역의 이전 역 <- 새로운 역의 이전 역
					sb.append(prev_stop[new_stop]).append('\n');	
				}
			}
			else if (cmd.charAt(0)=='C') {		// 폐쇄
				// CN : 고유 번호 i를 가진 역의 다음 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
				int del_stop = 0;
				if(cmd.charAt(1)=='N') {		// 다음역
					del_stop						= next_stop[n];
					next_stop[n]					= next_stop[del_stop];
					prev_stop[next_stop[del_stop]]	= n;	
				}
				// CP : 고유 번호 i를 가진 역의 이전 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
				else if(cmd.charAt(1)=='P') { 	// 이전역
					del_stop 						= prev_stop[n];
					prev_stop[n]					= prev_stop[del_stop];
					next_stop[prev_stop[del_stop]]	= n;
				}
				// 삭제할 역 초기화
				next_stop[del_stop]=0; prev_stop[del_stop]=0;
				sb.append(del_stop).append('\n');
			}
		}
		System.out.println(sb);

	}
}
