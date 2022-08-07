package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int N;                       // 총 지역 수
	static int[] peopleNum;             // 각 지역의 인구 수
	static boolean[] selected;          // 선거구에 선택된 지역을 담을 배열
	static boolean[] visited;           // 선거구가 연결되어있는 지를 담을 배열
	static int[][] graph;               // 각 지역의 연결을 나타낼 2차원 배열(그래프)
	static int min = Integer.MAX_VALUE; // 인구 수 차이의 최소값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		peopleNum = new int[N + 1];
		selected = new boolean[N + 1];
		graph = new int[N + 1][N + 1];

		// 구역 별 인구수 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			peopleNum[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 선거구 인접 지역 정보를 입력받아 그래프로 변환
		// 무방향 그래프
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= num; j++) {
				int row = Integer.parseInt(st.nextToken());
				graph[i][row] = 1;
				graph[row][i] = 1;
			}
		}
		
		divide(1);

		// min 값이 변경되지 않았다면 두 선거구로 나눌 수 없는 경우
		// -1 출력
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void divide(int index) {
		
		// 모든 지역을 검사했다면
		if (index == N + 1) {
			List<Integer> aArea = new ArrayList<Integer>();
			List<Integer> bArea = new ArrayList<Integer>();


			// selected가 true인 수(지역 번호)를 aArea
			// false인 수(지역 번호)를 bArea에 저장
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					aArea.add(i);
				} else {
					bArea.add(i);
				}
			}
			
			// 조건 1. 선거구는 구역을 적어도 하나 포함
			if (aArea.size() == 0 || (bArea.size() == 0)) {
				return;
			}
			
  			// 조건 2. 한 선거구에 포함된 구역은 모두 연결
			if (!(connected(aArea) && connected(bArea))) {
				return;
			}

			// 두 조건 모두 통과하였다면 선거구 인구 차이 계산
			int diff = getDiff(aArea, bArea);
			if (diff < min) {
				min = diff;
			}
			return;
		}

		// 해당 번호(index)가 선택된 경우
		selected[index] = true;
		divide(index + 1);
		
		// 해당 번호(index)가 선택되지 않은 경우
		selected[index] = false;
		divide(index + 1);
	}

	// 조건 2. 한 선거구에 포함된 구역은 모두 연결되었는지 확인하는 함수
	// BFS 사용
	static boolean connected(List<Integer> area) {

		visited = new boolean[N + 1];
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 큐에 area의 첫번째 지역의 번호 삽입
		queue.add(area.get(0));
		visited[area.get(0)] = true;
		int count = 0;

		// 0. 1~N번 지역까지,
		// 1. 큐의 맨 앞에 있는 지역과 인접해있고, 해당 선거구에 포함되어있다면
		// 2. visited를 true로 변경하고 큐에 해당 지역 삽입
		// 3. 큐의 맨 앞 원소 제거(poll)
		// 큐가 빌때까지 반복
		while (!queue.isEmpty()) {
			for (int i = 1; i <= N; i++) {
				if (graph[queue.peek()][i] == 1 && area.contains(i) && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
			queue.poll();
		}

		// 조건에 통과된 지역의 수가 Area의 수와 일치하면 해당 선거구의 모든 지역이 연결되어있음을 의미
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				count++;
		}

		if (count == area.size())
			return true;
		else
			return false;
	}

	// 각 선거구의 인원 수 차이
	static int getDiff(List<Integer> aArea, List<Integer> bArea) {
		int aSum = 0;
		int bSum = 0;
		for (Integer index : aArea) {
			aSum += peopleNum[index];
		}
		for (Integer index : bArea) {
			bSum += peopleNum[index];
		}
		return Math.abs(aSum - bSum);
	}

}
