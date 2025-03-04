// 문제: 백준 15663번 N과 M (9) : 중복 없는 순열
// 메모리: 25348 KB
// 시간: 192 ms

import java.io.*;
import java.util.*;

public class b15663 {
	static StringBuilder sb;
	static int N, M;
	static int[] result;
	static boolean[] visited;
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
		visited = new boolean[N];

		perm(0);

		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void perm(int idx) {

		if (idx == M) {
			for (int r : result)
				sb.append(r).append(' ');
			sb.append('\n');
			return;
		}

		// 이미 사용된 값인지 확인
		HashSet<Integer> used = new HashSet<>();

		for (int i = 0; i < N; i++) {
			if (visited[i] || used.contains(nums[i]))
				continue;

			visited[i] = true;
			result[idx] = nums[i];
			used.add(nums[i]);
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
