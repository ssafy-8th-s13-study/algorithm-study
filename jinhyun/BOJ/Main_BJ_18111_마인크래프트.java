import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_18111_마인크래프트 {

	
	// 블록 제거 : 2초
	// 블록 쌓기 : 1초
	static int N, M, B;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1<=M,N<=500
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken()); // 주어진 블록수
		
		map = new int[N][M];
		int[][] new_map = new int[N][M];
		
		// 복사
		for(int i = 0; i<N; i++) {
			new_map[i] = map[i].clone();
		}
		
		int targetHeight = -1; // 목표 높이
		int time = 0;
		int timeMin = Integer.MAX_VALUE;
		
		int maxH = 0;
		int minH = Integer.MAX_VALUE;
		
		//map 입력 (최소와 최대 높이를 구함)
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++){
				 int value= Integer.parseInt(st.nextToken());
				 map[i][j] = value;
				 if(maxH < value) {
					 maxH = value;
				 }
				 if(minH > value) {
					 minH = value;
				 }
			}
		}
		
		int build_block;
		int remove_block;
		int now;
		
		// 최소 높이부터 최대 높이 블록까지 반복
		for(int h = minH; h<= maxH; h++) {
			build_block = 0;
			remove_block = 0;
			
			// 해당 높이에서 회수할 블록, 설치할 블록 구하기
			for(int i = 0; i< N; i++) {
				for(int j = 0; j<M; j++) {
					now = map[i][j];
					
					if(h > now) { // 현재 블록이 h보다 낮으면 설치할 블록 개수 누적
						build_block += (h - now);
					}
					if(h < now) { // 현재 블록이 h보다 높으면 회수할 블록 개수 누적
						remove_block += (now - h);
					}
				}
			}
			
	        // 설치할 블록 개수가 인벤토리와 회수한 블록의합보다 부족한지 검사
	        if (build_block <= remove_block + B) {
	            time = remove_block * 2 + build_block;

	            if (timeMin >= time) {
	                if (targetHeight > h) continue;
	                timeMin = time;
	                targetHeight = h;
	            }
	        }
			
			
		}
		
		
		System.out.println(timeMin +" "+targetHeight);
		
		
	}//main


}
