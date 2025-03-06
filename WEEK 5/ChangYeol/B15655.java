// 문제: 백준 15655번 N과 M (6)
// 링크: https://www.acmicpc.net/problem/15655
// 시간: 104ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;
	static int[] select;
	static List<int[]> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		select = new int[M];
		result = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		comb(0, 0);

		for (int i = 0; i < result.size(); i++) {
			int[] arr = result.get(i);
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static void comb(int n, int r) {
		if (r == M) {
			result.add(Arrays.copyOf(select, M));
			return;
		}
		else if (n == N) {
			return;
		}

		select[r] = nums[n];
		comb(n + 1, r + 1);
		comb(n + 1, r);

	}
}
