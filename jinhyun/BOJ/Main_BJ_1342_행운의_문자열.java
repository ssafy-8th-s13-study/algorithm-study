import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1342_행운의_문자열 {

	static boolean[] isVisited;
	static char[] ans;
	static int[] arr;
	static int totalCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		arr = new int[26];
		isVisited = new boolean[s.length()];
		ans = new char[s.length()];
		totalCnt = 0;
		perm(0, 0, s);
		
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        
        //팩토리얼로 나눠주어 생성된 문자열의 중복을 정확히 없앨 수 있음 (aabbbaa)의 경우 144개 -> 1개
        //set으로 풀이하면 메모리 초과 발생
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 1)
                totalCnt /= factorial(arr[i]);
        }

		System.out.println(totalCnt);
	}

	static void perm(int cnt, int flag, String s) {
		if(cnt == s.length()) {
			if(isVerified()) {
				totalCnt++;
			}
			return;
		}
		
		for(int i = 0; i<s.length(); i++) {
			if((flag & 1 << i) != 0) continue;
			
			isVisited[i] = true;
			ans[cnt]=s.charAt(i);
			perm(cnt+1, flag|1<<i, s);
			isVisited[i] = false;
		}
		
	}
	
	static boolean isVerified() {
		for(int i = 1; i<ans.length; i++) {
			if(ans[i-1] == ans[i]) {
				return false;
			}
			if(i<ans.length-1 && ans[i+1] == ans[i]) {
				return false;
			}
		}
		return true;
	}
	
	static int factorial(int N) {
		if(N==1) {
			return 1;
		}
		return N * factorial(N-1);
	}
}
