package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23309_철도공사 {
	static int N, M;
    static int[] prev = new int[1_000_001]; //각 역의 이전 역을 저장할 배열
    static int[] next = new int[1_000_001]; //각 역의 다음 역을 저장할 배열

    static void addStation(int before, int after){
        prev[after] = before; //현재의 이전을 before를 가리키도록
        next[after] = next[before]; //before가 가리키던 다음번호를 after가 가리키도록
        prev[next[after]] = after; //after가 가리키는 다음 번호가 after를 이전 번호로 가리키게
        next[before] = after; //before의 다음 역으로 after로
    }
    
    static void removeStation(int num) {
    	//num을 지우면서 앞뒤로 있는 역을 연결해줌
    	next[prev[num]] = next[num]; //num의 이전 역의 다음 역을 num의 다음 역으로 연결 
    	prev[next[num]] = prev[num]; //num의 다음 역의 이전 역을 num의 이전 역으로 연결
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); //역의 개수
        M = Integer.parseInt(st.nextToken()); //공사 횟수

        st = new StringTokenizer(br.readLine());
        int index = Integer.parseInt(st.nextToken()); //첫번째 역
        prev[index] = index; //0 출력 방지
        next[index] = index;

        for(int i=1; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            //첫번째 역을 제외한 나머지 역
            addStation(index, now);
            index = now; //인덱스를 현재 값으로 갱신
        }

        int x,y;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){

                case "BN": //다음 역 설립
                    x = Integer.parseInt(st.nextToken());
                    y= Integer.parseInt(st.nextToken());
                    sb.append(next[x]).append("\n"); //x의 다음 역 출력
                    addStation(x, y); //x와 y를 연결
                    break;

                case "BP": //이전 역 설립
                    x = Integer.parseInt(st.nextToken());
                    y= Integer.parseInt(st.nextToken());
                    sb.append(prev[x]).append("\n"); //x의 이전 역 출력
                    addStation(prev[x], y); //x의 이전역과 y를 연결
                    break;

                case "CN": //다음 역 폐쇄
                    x = Integer.parseInt(st.nextToken());
                    sb.append(next[x]).append("\n"); //x의 다음 역 출력
                    removeStation(next[x]); //x의 다음 역 삭제
                    break;

                case "CP": //이전 역 폐쇄
                    x = Integer.parseInt(st.nextToken());
                    sb.append(prev[x]).append("\n"); //x의 이전 역 출력
                    removeStation(prev[x]); //x의 이전 역 삭제
                    break;
            }//end switch

        }//end 공사

        System.out.print(sb); //출력

    }//end main

}//end body