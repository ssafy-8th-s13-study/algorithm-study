import java.util.Scanner;

public class Solution_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int t = sc.nextInt();
			int N = sc.nextInt();
			int m = sc.nextInt();
			int result=1;
			for(int i=0;i<m;i++) {
				result*=N;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
