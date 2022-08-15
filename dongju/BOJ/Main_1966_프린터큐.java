package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //문서의 개수
            int m = Integer.parseInt(st.nextToken()); //구해야 하는 문서의 위치
            int cnt = 1;
            LinkedList<int[]> q = new LinkedList<>(); //{인덱스, 중요도} 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){ //문서의 인덱스와 중요도를 큐에 저장
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            while(!q.isEmpty()){//큐가 빌때까지 반복
                int max = 0;
                for(int i=0; i< q.size(); i++){ //리스트를 탐색하며 가장 큰 중요도를 찾는다
                    if(max < q.get(i)[1]){
                        max = q.get(i)[1];
                    }
                }
                int[] temp = q.poll(); //큐의 맨 앞 poll
                if(temp[1] < max){ //남은 큐의 가장 큰 중요도보다 작다면 큐의 맨 뒤로 재배치
                    q.offer(temp);
                }else{ //가장 큰 중요도일 경우 => 출력
                    if(temp[0] == m) {  //찾는 문서의 위치라면 출력하고 반복문 종료
                        System.out.println(cnt++);
                        break;
                    }
                    cnt++;  //출력횟수 증가
                }
            }
        }
    }
}