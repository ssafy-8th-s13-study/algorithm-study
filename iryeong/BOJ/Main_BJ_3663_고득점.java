package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_3663_고득점 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		String name;
		for (int test_case = 0; test_case < N; test_case++) {
			name = br.readLine().trim();
			int size = name.length();
			int ret = 0;
			int AStart[] = new int[size]; // A가 시작하는 index
			int AEnd[] = new int[size]; // A가 끝나고 다른 알파벳이 나오기 시작하는 index
			char tmp;
			int flag = 0, sIdx = 0, eIdx = 0;
			for (int j = 0; j < size; j++) {
				tmp = name.charAt(j);
				if (flag == 0 && tmp == 'A') { // A가 처음 나옴
					AStart[sIdx++] = j;
					flag = 1;
				} else if (flag == 1 && tmp != 'A') { // A가 아닌 알파벳이 나오기 시작
					flag = 0;
					AEnd[eIdx++] = j;
				} else if (flag == 1 && tmp == 'A') {
					continue;
				}
				// 각 index에 있는 알파벳을 입력하기 위한 조이스틱 움직임 횟수
				ret += Math.min(tmp - 65, 26 - (tmp - 65));
			}
			// 이름 맨 마지막이 A일 때 위 for문에서 안 세어지므로 따로 처리
			if (name.charAt(size - 1) == 'A') {
				AEnd[eIdx] = size;
			}
			// A가 가장 많이 연속으로 있는 구간 찾기
			int max = 0, cnt, idx = 0;
			for (int i = 0; i < sIdx; i++) {
				cnt = Math.abs(AStart[i] - AEnd[i]);
				if (max < cnt) {
					max = cnt;
					idx = i;
				}
			}
			if (max == 0) {
				ret += (size - 1);
			} else if ((AEnd[0] + 1 + size - AEnd[eIdx]) >= max && AStart[0] == 0 && AEnd[eIdx] == size) {
				if (size - AStart[sIdx - 1] >= AEnd[0]) {
					ret += Math.max(AStart[sIdx - 1] - 1, 0);
				} else {
					ret += Math.max(size - AEnd[0], 0);
				}
			} else {
				int c1 = size - AEnd[idx] + 2 * AStart[idx] - 2;
				int c2 = 2 * size - 2 * AEnd[idx] + AStart[idx] - 1;
				// 끝(0)에서 AEnd로 왔다가 다시 되돌아서 처음으로 간다음 AStart로 가는 경우
				if (c1 >= c2) {
					ret += c2;
					if (name.charAt(0) != 'A' && name.charAt(1) == 'A') {
						ret -= 1;
					}
				}
				// 0부터 AStart로 왔다가 다시 되돌아서 끝까지 간 다음 AEnd로 가는 경우
				else {
					ret += c1;
					if (AStart[idx] == 0) {
						ret += 1;
					}
				}
			}
			sb.append(ret + "\n");
		}
		System.out.println(sb);
	}

}
