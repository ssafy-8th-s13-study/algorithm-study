import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1049_기타줄 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int ans =  1000;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 끊어진 줄 수
		int M = Integer.parseInt(st.nextToken()); // 브랜드 수
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int six = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			list.add(new int[]{six, one});
		}
		
		// 6개 세트 기준으로 정렬
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]){
					return -1;
				}else if (o1[0]> o2[0]){
					return 1;
				}
				return 0;
			}
		});
		
		
		// 6개 패키지로만 수량 채우는 방법
		if(N <= 6 ) {
			ans = list.get(0)[0];
		}else {
			ans = N%6==0 ? list.get(0)[0] * (N / 6) : list.get(0)[0] * (N / 6 + 1);
		}

		int temp = 0;
		// 6개 패키지로 일정부분 채우고 낱개로 일정부분 채우는 방법
		temp = list.get(0)[0] * (N/6);
		// 낱개 기준으로 정렬
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]){
					return -1;
				}else if (o1[1]> o2[1]){
					return 1;
				}
				return 0;
			}
		});
		temp += (N%6) * list.get(0)[1];
		if (ans > temp) {
			ans = temp;
		}
		
		// 낱개로만 수량 채우는 방법
		temp = N * list.get(0)[1];
		if(ans > temp) {
			ans = temp;
		}
		

		System.out.print(ans);
	}

}
