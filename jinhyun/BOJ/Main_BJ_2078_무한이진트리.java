import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2078_무한이진트리 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int L = 0; // 왼쪽으로 이동한 회수
		int R = 0; // 오른쪽으로 이동한 회수
		
		while(a != b) { // a와 b가 같아질 때까지 반복 : 루트노드 
						//루트 노드 이외에 절대 a와 b는 같을 수 없다.
			// 부모 노드 값 재현
			if(a > b) { 
				L += 1;
				a -= b;
			}
			if(a < b) {
				R += 1;
				b -= a;
			}
		}
		
		sb.append(L).append(" ").append(R);
		
		System.out.println(sb);
		
	}//main

}
	