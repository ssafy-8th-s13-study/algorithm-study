package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
    static int N, res = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        map = new int[N][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 끝

        //첫 방문을 모든 도시 선택을 할 때 108ms
//        for(int i=0; i<N; i++){
//            visited[i] = true;
//            tsp(0, i, i, 0);
//        }

        //첫번째 방문 도시를 0번째로 설정 => 88ms
        visited[0] = true;
        tsp(0, 0, 0, 0);

        System.out.println(res);
        br.close();
    }

    private static void tsp(int dept, int start, int now, int cost){
        if(dept == N-1){ //모든 도시를 방문함 (첫번째 도시를 이미 정했기 때문에 N-1
            if(map[now][start] != 0){
                //최소 비용 처리
                res = Math.min(res, cost + map[now][start]);
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i] && map[now][i] != 0 && cost < res){//방문하지 않았고, 갈 수 있고, 비용이 결과값보다 작을 때
                visited[i] = true;
                tsp(dept+1, start, i, cost + map[now][i]);
                visited[i] = false;
            }
        }
    }
}
