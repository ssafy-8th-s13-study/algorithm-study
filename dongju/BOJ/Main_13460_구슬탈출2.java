package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {

    static int N, M; //배열 크기
    static char[][] map;
    static Point pos; //처음 빨간구슬, 파란구슬 저장할 위치

    static int[] dr = {-1, 1, 0, 0}; //상하좌우 이동
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        //빨간구슬, 파란구슬, 총 이동 횟수 저장
        int rx, ry, bx, by, cnt;

        public Point() {
        }

        public Point(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        pos = new Point();
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'R') {//빨간 구슬 위치 입력
                    pos.rx = i;
                    pos.ry = j;
                } else if (map[i][j] == 'B') {//파란 구슬 위치 입력
                    pos.bx = i;
                    pos.by = j;
                }
            }
        }

        pos.cnt = 0; //초기 이동값 0

        bfs();

    }//end main

    private static void bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(pos);
        boolean[][][][] v = new boolean[N][M][N][M]; //앞의 [][]는 빨간구슬 확인, 뒤의 [][]는 파란구슬 확인. 이 체크 안하면 계속 실행됨

        while (!queue.isEmpty()) {
            Point cur = queue.poll(); //현재 위치 가져옴
            v[cur.rx][cur.ry][cur.bx][cur.by] = true; //방문했다 표시

            if (cur.cnt >= 10) {//10회 이상 움직이면 -1
                System.out.println(-1);
                return;
            }

            for (int d = 0; d < 4; d++) {//4방으로 굴려봄

                boolean red = false, blue = false; //어느 구슬이 빠졌는지 확인할 flag

                //빨간공 먼저 굴림
                int rx = cur.rx;
                int ry = cur.ry;

                while (map[rx + dr[d]][ry + dc[d]] != '#') {//벽 안 만날때까지
                    rx += dr[d]; //선택한 방향으로 인덱스 증가
                    ry += dc[d];
                    if (map[rx][ry] == 'O') {//구멍만나면 탈출
                        red = true; //빨간구슬이 빠졌다고 표시
                        break;
                    }
                }

                //파란공 굴림
                int bx = cur.bx;
                int by = cur.by;

                while (map[bx + dr[d]][by + dc[d]] != '#') {//벽 안 만날때까지
                    bx += dr[d];
                    by += dc[d];
                    if (map[bx][by] == 'O') {//구멍만나면 탈출
                        blue = true; //파란구슬 빠졌다고 표시
                        break;
                    }
                }

                if (blue) {//파란공이 빠졌는지 먼저 체크. 빠졌으면 아래 진행 안 하고 다음 방향으로 넘어감
                    continue;
                }
                if (red) {//파란공 안 빠지고, 빨간공이 빠졌으면 결과 출력후 종료. bfs이기 때문에 최소 횟수가 됨
                    System.out.println(cur.cnt + 1);
                    return;
                }

                if (rx == bx && ry == by) { //빨간구슬과 파란구슬이 같은 위치에 도착했다면, 처음 위치에서 어느쪽이 먼저 있는지 확인
                    switch (d) { //움직이는 방향에 따라서 도착위치 파악 가능
                        case 0: //위로 움직이는 방향. 열이 같음
                            if (cur.rx < cur.bx) //처음에 빨간파란구슬 위치 비교.
                                bx += 1; //도착지점 비교. 빨간공이 초기에 파란구슬보다 앞에 있다면 빨간공이 먼저 도착하기 때문에 파란공은 한칸 아래로 내려줌
                            else
                                rx += 1;
                            break;
                        case 1: //아래로 움직이는 방향. 열이 같음
                            if (cur.rx < cur.bx) //처음에 빨간파란구슬 위치 비교
                                rx -= 1; //도착지점 비교
                            else
                                bx -= 1;
                            break;
                        case 2: //좌로 움직이는 방향. 행이 같음
                            if (cur.ry < cur.by) //처음에 빨간파란구슬 위치 비교
                                by += 1; //도착지점 비교
                            else
                                ry += 1;
                            break;
                        case 3: //우로 움직이는 방향. 행이 같음
                            if (cur.ry < cur.by) //처음에 빨간파란구슬 위치 비교
                                ry -= 1; //도착지점 비교
                            else
                                by -= 1;
                            break;
                    }
                }

                if (!v[rx][ry][bx][by]) { //벽을 만났을때 갈 수 있는 새로운 위치 큐에 넣어줌
                    queue.offer(new Point(rx, ry, bx, by, cur.cnt + 1));
                }
            }
        }
        System.out.println(-1); //다 돌았는데도 못나오면 -1
    }


}
