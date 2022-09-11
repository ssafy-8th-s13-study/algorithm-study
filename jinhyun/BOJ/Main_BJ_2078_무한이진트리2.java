import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2078_무한이진트리2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int L = 0; // 왼쪽으로 이동한 회수
		int R = 0; // 오른쪽으로 이동한 회수
		
		while(true) { 
			// 다음 연산을 통해서 연속적으로  L 또는 R로 이동하는 경우를 체크할 수 있다.
			if(a > b) {
				L += a/b; // b의 크기에 따라서 L의 값이 결정된다. b의 크기가 유지된 회수 = 좌측 이동 회수
				a = a%b; // L방향으로 이동하고도 남은 a의 값을 저장한다.
				if (a == 0) { // 종료 조건 (b가 1이 되고 a%b == 0이 되는 상황을 고려)
					L -= 1; // 1로 나눠진 경우 원하는 결과보다 1 큰 값이 L에 추가되기 떄문에 -1해준다.
					break;
				}
			}
			else if(a < b) {
				R += b/a;
				b = b%a;
				if (b == 0) {
					R -= 1;
					break;
				}
			}
		}
		
		sb.append(L).append(" ").append(R);
		
		System.out.println(sb);
		
	}//main

}
	