// 문제: 백준 13305번 주유소
// 메모리: 36600KB
// 시간: 332ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 계단의 수
		
		int[] steps = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}//계단 별 점수 입력
		
		// DP 배열: dp[i]는 i번째 계단까지 올라왔을 때의 최대 점수
		int[] dp = new int[N+1];
		
		if(N >= 1) dp[1] = steps[1];
		if(N >= 2) dp[2] = steps[1] + steps[2];
		if(N >= 3) dp[3] = Math.max(steps[1] + steps[3], steps[2] + steps[3]);
		
		for(int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] + steps[i]); // (i-2)에서 점프, (i-3) → (i-1) → i 최댓값 선택
		}
		
		System.out.println(dp[N]);
	}
}
