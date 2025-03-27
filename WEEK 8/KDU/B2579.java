// 문제: 백준 2579번 
// 문제제목 : 계단 오르기
// 링크: https://www.acmicpc.net/problem/2579
// 메모리 : 14156KB
// 시간: 104ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb;
	static int N;
	static int max;
	static int sum;
	static int[] stair;
	static int tmpidx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
        // 점화식을 만들 수 있는 경우의 수
        // 1. dp[i] = dp[i-2] + stair[i] -> 2개 계단 점프
        // 2. dp[i] = dp[i-3] + stair[i-1] + stair[i] -> 2개 계단 점프 + 1개 계단 점프프
		int[] dp = new int[N + 1];
		dp[1] = stair[1];
		if (N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		if (N >= 3) {
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
			}
		}
		sb.append(dp[N]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

