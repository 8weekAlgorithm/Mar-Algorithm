// 문제: 15661 링크와 스타트
// 메모리: 22800 KB
// 시간: 904 ms

import java.io.*;
import java.util.*;

public class B15661_backtracking {
    static int N;
	static int[][] S;
	static boolean[] visited;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 최적화된 백트래킹 시작 (팀을 절반만 선택)
		backtrack(0, 0);

		bw.write(minDiff + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	// 최적화된 백트래킹 함수 (팀을 절반만 선택)
	static void backtrack(int index, int count) {
		// 팀이 절반을 넘어서면 종료
		if (count > N / 2)
			return;

		// 최소 인원 이상 선택되면 능력치 계산
		if (count > 0) {
			int diff = calculateDifference();
			minDiff = Math.min(minDiff, diff);
		}

		// 모든 사람을 고려했으면 종료
		if (index == N)
			return;

		// 현재 index를 링크팀에 포함
		visited[index] = true;
		backtrack(index + 1, count + 1);

		// 현재 index를 스타트팀에 포함
		visited[index] = false;
		backtrack(index + 1, count);
	}

	// 능력치 차이 계산
	static int calculateDifference() {
		int linkScore = 0, startScore = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j])
					linkScore += S[i][j];
				else if (!visited[i] && !visited[j])
					startScore += S[i][j];
			}
		}

		return Math.abs(linkScore - startScore);
	}
}