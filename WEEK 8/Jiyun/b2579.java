// 문제: 2579 계단 오르기
// 메모리: 14184 KB
// 시간: 104 ms

import java.io.*;

public class b2579 {
	static int N;
	static int[] stairs, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stairs = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];

        System.out.println(dp[N]);
	}
}