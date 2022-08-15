import java.util.Scanner;
// 메모리 초과!
// 내생각에 DP 문제 같다.
public class Main_2078_무한이진트리 {
	static int l_cnt = 1;
	static int r_cnt = 1;
	static int l_num = 0;
	static int r_num = 0;
	
	static void find(int l, int r, int l_c, int r_c) {
		if(l==l_num&&r==r_num) {System.out.println(l_c+" "+r_c); return;}
		if(l>l_num) return;
		if(r>r_num) return;
		System.out.println(l+" "+r+"  l_cnt : "+l_c+" r_cnt : "+r_c);
		find(l+r,r,l_c+1,r_c);
		find(l,l+r,l_c,r_c+1);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l_num = sc.nextInt();
		r_num = sc.nextInt();
		int L=0, R=0;
//		find(1,1,0,0);
		// 거꾸로 생각하기
		while(!(l_num==1&&r_num==1)) {
			// 왼쪽 숫자가 오른쪽 숫자보다 크다
			if(l_num>r_num) {
				L+=1;
				l_num-=r_num;
			}
			// 오른쪽 숫자가 왼쪽 숫자보다 크다
			else {
				R+=1;
				r_num-=l_num;
			}
		}
		System.out.println(L+" "+R);
		
		sc.close();
	}
}
