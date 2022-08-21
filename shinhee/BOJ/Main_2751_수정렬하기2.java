import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2751_수정렬하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int cnt = sc.nextInt();
		ArrayList <Integer> arr = new ArrayList <Integer>();
		for(int i=0;i<cnt;i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		for(int a : arr) {
			sb.append(a).append('\n');
		}
		System.out.println(sb);
	}
}
