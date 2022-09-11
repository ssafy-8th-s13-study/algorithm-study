import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_3663_고득점 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		
		for(int tc = 0; tc<T; tc++) {
			int total = 0;
			String name = br.readLine(); // 이름
		
			total += calcUpDown(name); // 상하 이동 횟수 카운트
			total += calcLeftRight(name); // 좌우 이동 횟수 카운트
			
			System.out.println(total);
			
			
		}// test-case 반복
		
	}// main

	// 상하 이동 횟수
	static int calcUpDown(String name) {
		int size= name.length();
		int count = 0;
		
		for(int i = 0; i<size; i++) {
			char c = name.charAt(i);
			if(c >= 'A' && c <= 'N') {
				count += c-'A';
			}
			else {
				count += 'Z' - c + 1;
			}
		}
		return count;
	}
	
	// 좌우 이동 횟수
	static int calcLeftRight(String name) {
	    int size = name.length();
	    int count = size - 1; // 좌우 이동의 최대값을 count값으로 설정
	    
	    for (int i = 0; i < size; i++)
	    {
	        int next = i + 1;
	        while (next < size && 'A' == name.charAt(next)) {	        	
	        	next++;
	        }
	        count = Math.min(count, i + size - next + Math.min(i, size - next));
	    }
	    
	    return count;
	}
}
