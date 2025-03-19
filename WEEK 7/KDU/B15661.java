// 문제: 백준 15661번 
// 문제제목 : 링크와 스타트
// 링크: https://www.acmicpc.net/problem/15661
// 메모리 : 20188KB
// 시간: 812ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661 {

	static StringBuilder sb;
	static int[][] power;
	static StringTokenizer st;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeTeam(0, 0, 0);

		System.out.println(min);
	}

	// 팀의 순서가 바뀐다고 다른 팀이 되는 것이 아니므로 조합을 사용
	// -> 조합이 아니라 부분집합을 사용해야됨(6명이면 3/3으로나눠야 되므로..?)

    // SWEA 요리사 문제는 N이 항상 짝수로 들어오기 때문에 예외처리가 간단하였으나
    // 해당 문제는 홀수도 가정하므로 홀수로 들어왔을때를 고려해야 됨
    // 또한 팀을 정확히 절반으로 나누는 경우가 아닌 모든 경우의 수를 고려하므로 부분집합이 적절함
	static void makeTeam(int idx, int bitmask, int count) {
		// 가지치기: N/2를 넘어가면 탐색할 필요 없음 (대칭이므로 절반만 탐색)
		if (count > N / 2)
			return;

		// 최소 한 명 이상이 양 팀에 속해야 계산 수행
		if (idx == N) {
			if (count > 0) {
				min = Math.min(min, powerdiff(bitmask));
			}
			return;
		}

		// 현재 idx 번째 선수를 스타트 팀에 포함 (bitmask에 추가)
		makeTeam(idx + 1, bitmask | (1 << idx), count + 1);

		// 현재 idx 번째 선수를 링크 팀에 포함 (bitmask 변경 없음)
		makeTeam(idx + 1, bitmask, count);
	}

	// 각 팀별로 시너지를 더해서 차이값을 반환해줘야됨
	static int powerdiff(int bitmask) {

		int powerstart = 0;
		int powerlink = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// 스타트 팀 방문처리
				if ((bitmask & (1 << i)) != 0 && (bitmask & (1 << j)) != 0) {
		            // 스타트 팀의 능력치를 저장해주자
					powerstart += power[i][j] + power[j][i];
				// 링크 팀 방문처리
				} else if ((bitmask & (1 << i)) == 0 && (bitmask & (1 << j)) == 0) {
                    // 링크 팀의 능력치를 저장해주자
					powerlink += power[i][j] + power[j][i];
				}
			}
		}

		return Math.abs(powerstart - powerlink);
	}

}