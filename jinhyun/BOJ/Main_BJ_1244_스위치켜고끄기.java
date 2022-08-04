import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int switchNum = Integer.parseInt(br.readLine()); // 스위치 갯수 : 100이하 양의 정수
		int[] states = new int[switchNum]; 				 // 스위치 상태 배열
		
		String switchNumString = br.readLine();
		st = new StringTokenizer(switchNumString, " ");
		

		for (int i = 0; i < switchNum; i++) { 			 // 스위치 초기 상태 저장
			states[i] = Integer.parseInt(st.nextToken());
		}
		
	
		int stdNum = Integer.parseInt(br.readLine());    //	학생 수
		int[][] coms = new int[stdNum][2];  			 // coms [성별][받은 수]
		
		// 학생 수만큼 동작 실행
		for (int i = 0; i < stdNum; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			
			coms[i][0] = Integer.parseInt(st.nextToken());
			coms[i][1] = Integer.parseInt(st.nextToken());
			
			int gender = coms[i][0]; 	// 성별
			int index = coms[i][1]-1;	// 받은 수(스위치 인덱스) ex) 3 -> 2 index
			
			
			switch(gender) {
			case 1: // 남자
				for (int j = 0; j < states.length; j++) { // 스위치 조작
					if((j+1) % (index+1) == 0) { // 원래 스위치 번호로 변경 후 계산
						states[j] = states[j] == 0 ? 1:0;
					}
				}
				break;
			case 2: // 여
				// 지정된 index 상태 뒤집기 1->0, 0->1				
				states[index] = states[index] == 0 ? 1 : 0;
				
				// 대칭 구간 뒤집기
				int inc = 1; // 오른쪽 대칭 맞추기 위한 변수
				if (index > 0 && index < states.length && states.length>2){ // 대칭 탐색 범위
					for (int j = index-1; j >= 0; j--) { // index 바로 앞부터 비교
						if (index+inc >= states.length) { // 오른쪽 인덱스 범위가 초과면 대칭 비교 전 종료 종료
							break;
						}
						if (states[j] == states[index+inc]) { // j = 좌측 대칭 비교 인덱스, index+inc = 우측 대칭 비교 인덱스
							if (states[j] == 0) { // 뒤집기
								states[j] = 1;
								states[index+inc] = 1; 
							}else {
								states[j] = 0;
								states[index+inc] = 0;
							}
						}else {
							break;
						}
						inc += 1; // 오른쪽 인덱스 증가 ( 좌측 인덱스는 for문에서 감소 )
					}
				}
				break;
			}// switch 문

		}// 실행 for문

		// 출력		
		for (int i = 1; i < states.length+1; i++) {
			if (i % 20 == 0) {
				System.out.println(states[i-1]);
			}else {
				System.out.print(states[i-1] +" ");
			}
		}
	}

}