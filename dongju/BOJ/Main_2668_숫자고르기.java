package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2668_숫자고르기 {
	
	static int N, index;
	static int[] arr;
	static int[] result;
	static boolean[] check;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine())+1;
		arr = new int[N];
		check = new boolean[N];
		
		for(int i=1; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		
		for(int i=1; i<N; i++) {
			check[i] = true;
			index = i;
			dfs(i);
			check[i] = false; 
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
		
	}

	private static void dfs(int i) {
		if(arr[i] == index) { //dfs로 돌아서 배열의 값이 인덱스로 돌아오면 사이클 생성됨 1,3 / 3,1 이면 1저장되고, 다음 방문에서 3이 저장됨
			list.add(index);
		}
		
		if(!check[arr[i]]) {
			check[arr[i]] = true;
			dfs(arr[i]);
			check[arr[i]] = false; 
		}
	}

}
