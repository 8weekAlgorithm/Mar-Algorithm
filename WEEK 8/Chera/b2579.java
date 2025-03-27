/**
 * 문제 : 백준 2579번 계단오르기
 * 메모리 : 14268KB
 * 시간 : 108ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2579 {
	static int N, max;
	static int[] stairs, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[N];

		max = Integer.MIN_VALUE;
		up(0);
		System.out.println(max);

	}

	static void up(int idx) {
		if (idx == N) {
			max = Math.max(max, dp[idx - 1]);
			return;
		}
		if (idx == 0) {
			dp[idx] = stairs[idx];
			up(idx + 1);
		}
		if (idx == 1) {
			dp[idx] = Math.max(dp[idx - 1], 0) + stairs[idx];
			up(idx + 1);
		}
		if (idx == 2) {
			dp[idx] = Math.max(stairs[idx - 2], stairs[idx - 1]) + stairs[idx];
			up(idx + 1);
		}
		if (idx > 2) {
			dp[idx] = Math.max(dp[idx - 2], dp[idx - 3] + stairs[idx - 1]) + stairs[idx];
			up(idx + 1);
		}

	}

}
