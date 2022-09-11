import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1654_랜선_자르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 영식이가 갖고 있는 랜선 K개
		int N = Integer.parseInt(st.nextToken()); // 영식이가 필요한 랜선 N개
		
		int[] k_lans = new int[K];
		int max = 0;
		
		// K개의 랜선 각 길이 입력
		for(int i =0; i<K; i++) {
			int lanLen = Integer.parseInt(br.readLine());
			k_lans[i] = lanLen;
			max = Math.max(max, lanLen);
		}
			
		long low = 1;
		long high = max;
		long ans = 0;
		
		while(low<=high) {			
			long mid = (low+high)/2;
			int count = 0;
			
			for(int i = 0; i<K; i++) {
				count += k_lans[i]/mid;
			}
			
			if (count >= N) {
				ans = Math.max(ans, mid);
				low = mid+1;
			}
			if (count < N) {
				high = mid-1;
			}
		}
		
		System.out.println(ans);
		
	}//main

}
