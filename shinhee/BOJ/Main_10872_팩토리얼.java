import java.util.Scanner;

public class Main_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 초기값 1 설정 
		int result=1;
		// 입력값 받기
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			result*=i;
		}
		System.out.println(result);
	}
}
