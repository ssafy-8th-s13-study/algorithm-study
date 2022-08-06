import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main_BJ_1920_수_찾기 {
	public static int[] nums;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {		
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {		
			int target = Integer.parseInt(st.nextToken());
			if (find(target) == true) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	// 이분탐색
	public static boolean find(int n) {
		int lo = 0, hi = N-1;	
		while(lo <= hi) {
			int mid = (lo + hi) >> 1;
			if (nums[mid] == n) {
				return true;
			}
			if (nums[mid] < n) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		return false;
		
	}
}