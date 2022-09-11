import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_18870_좌표_압축 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		// 원본 배열
		Integer[] original = new Integer[N];
		
		for(int i = 0; i<N; i++) {
			original[i]= Integer.parseInt(st.nextToken());
		}
		
		// 중복 제거
		Set<Integer> set = new HashSet<>(Arrays.asList(original)); 
		// set -> array
        Integer[] tempList = set.toArray(new Integer[0]);
        // 배열 정렬
        Arrays.sort(tempList);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i<tempList.length; i++) {
        	map.put(tempList[i], i);
        }
        
        for(int i = 0; i <original.length; i++) {
        	sb.append(map.get(original[i])+" ");
        }
		System.out.println(sb);
	}//main

}
