// 문제: 2579 계단 오르기
// 메모리: 14216 KB
// 시간: 104 ms


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		// 1-based 인덱싱
		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		// 초기값 설정
		if (N >= 1) dp[1] = stairs[1];
		if (N >= 2) dp[2] = stairs[1] + stairs[2];
		
		// 점화식 적용
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
		}
		
		bw.write(String.valueOf(dp[N]));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
