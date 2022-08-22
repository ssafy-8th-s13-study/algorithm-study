package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_SWEA_1227_미로2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(br.readLine());
			int[][] matrix = new int[100][100];
			int startX = 0, startY = 0;
			String input;
			for (int i = 0; i < 100; i++) {
				input = br.readLine();
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = input.charAt(j) - 48;
					if (matrix[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			sb.append("#" + test_case + " " + check(matrix, startX, startY) + "\n");
		}
		System.out.println(sb);
	}

	private static int check(int[][] matrix, int startX, int startY) {
		Queue<Pair> q = new LinkedList<>();
		int[][] visited = new int[100][100];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		q.offer(new Pair(startX, startY));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x >= 0 && p.x < 100 && p.y >= 0 && p.y < 100) {
				if (visited[p.x][p.y] == 0) {
					visited[p.x][p.y] = 1;
					if (matrix[p.x][p.y] == 0 || matrix[p.x][p.y] == 2) {
						for (int i = 0; i < 4; i++) {
							q.offer(new Pair(p.x + dx[i], p.y + dy[i]));
						}
					} else if (matrix[p.x][p.y] == 3) {
						return 1;
					}
				}
			}

		}
		return 0;
	}

}
