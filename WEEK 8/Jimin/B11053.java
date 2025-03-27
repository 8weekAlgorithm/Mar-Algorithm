// 문제: 가장 긴 증가하는 부분 수열
// 메모리: 15204 KB
// 시간: 128 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class B11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine());

		int[] arr = new int[A];
		int[] dp = new int[A];

		for (int i = 0; i < A; i++) {
			dp[i] = 1;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0) continue;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A; i++) {
			max = Math.max(max, dp[i]);
		}
		bw.write(String.valueOf(max));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
