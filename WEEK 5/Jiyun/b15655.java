// 문제: 백준 15663번 N과 M (6) : 중복 없는 조합
// 메모리: 14244 KB
// 시간: 104 ms

import java.io.*;
import java.util.*;

public class b15655 {
	static StringBuilder sb;
	static int N, M;
	static int[] result;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		br.close();

		// 풀이 시작
		Arrays.sort(nums);
		result = new int[M];
		comb(0, 0);

		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void comb(int idx, int start) {

		if (idx == M) {
			for (int r : result)
				sb.append(r).append(' ');
			sb.append('\n');
			return;
		}

		for (int i = start; i < N; i++) {
			result[idx] = nums[i];
			comb(idx + 1, i + 1);
		}
	}
}
