// 문제: 12865 평범한 배낭
// 메모리: 53800 KB
// 시간: 176 ms

import java.io.*;
import java.util.*;

public class b12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] item = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken()); // 무게
			item[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		// 풀이 시작
		int[][] DP = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) { // i번째 물건까지 고려
			for (int j = 1; j <= K; j++) { // 현재 가방 무게 제한
				int W = item[i - 1][0]; // 무게
				int V = item[i - 1][1]; // 가치

				if (j < W) // 무게제한보다 무거우면 물건을 넣지않음
					DP[i][j] = DP[i - 1][j];
				else
					DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - W] + V);
			}
		}

		for (int[] dp : DP)
			System.out.println(Arrays.toString(dp));

		System.out.println(DP[N][K]);
	}
}
