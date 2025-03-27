/**
 * 문제 : 백준 11053번 가장 긴 증가하는 부분 수열
 * 메모리 : 14444KB
 * 시간 : 124ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11053 {
	static int[] arr, dp;
	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N];
		max = 1;
		findPerm();
		System.out.println(max);

	}

	static void findPerm() {

		dp[0] = 1;
		for (int i = 1; i < N ; i++) {
			dp[i] = 1;
			for (int j = 0; j <i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
	}

}
