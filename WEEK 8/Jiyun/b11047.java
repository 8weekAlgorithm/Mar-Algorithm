// 문제: 11047 동전 0
// 메모리: 14216 KB
// 시간: 104 ms

import java.io.*;
import java.util.*;

public class b11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];

		for (int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());

		// 그리디 : 크기가 큰 동전부터 사용
		int answer = 0;
		for (int i = N - 1; i >= 0; i--) {
			answer += K / coins[i];
			K = K % coins[i];
		}
		System.out.println(answer);
	}
}
