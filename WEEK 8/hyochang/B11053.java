
//문제 11053 가장 긴 증가하는 부분수열
//메모리 : 14472kb
//시간 : 120ms
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// dp 배열에는 arr[i]가 가질 수 있는 가질 수 있는 배열의 길이
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		// 부분 수열 뽑음
		// i는1부터 시작해서
		// j는 0부터 i까지

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {// 현재 고른 수보다 작으면 +1을 함
					dp[i] = Math.max(dp[i], dp[j] + 1);// dp[j]는 arr[j]보다 작은 애들의 값임
				}
			}

		}
		int max = 0;
		for (int i = 0; i < n; i++) {// 배열에서 최댓값이 최고 길이
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}