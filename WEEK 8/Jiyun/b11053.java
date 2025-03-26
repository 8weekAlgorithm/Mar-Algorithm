// 문제: 11053 가장 긴 증가하는 부분 수열
// 메모리: 14568 KB
// 시간: 128 ms

import java.io.*;
import java.util.*;

public class b11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		// 풀이 시작
		int[] DP = new int[N];
		DP[0] = 1;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j])
					DP[i] = Math.max(DP[i], DP[j]);
			}

			DP[i] += 1;
			if (DP[i] == 0)
				DP[i] = 1;
		}

		int answer = 0;
		for (int dp : DP)
			answer = Math.max(dp, answer);

		System.out.println(answer);
	}
}
