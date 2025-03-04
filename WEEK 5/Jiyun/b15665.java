// 문제: 백준 15665번 N과 M (11) : 중복 있는 순열
// 메모리: 35188 KB
// 시간: 348 ms

import java.io.*;
import java.util.*;

public class b15665 {
	static StringBuilder sb;
	static int N, M;
	static List<Integer> nums;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Set<Integer> numSet = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			numSet.add(Integer.parseInt(st.nextToken()));
		br.close();
		
		// 풀이 시작
		nums = new ArrayList<>(numSet);
		Collections.sort(nums);
		result = new int[M];

		perm(0);

		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void perm(int idx) {

		if (idx == M) {
			for (int i = 0; i < M; i++)
				sb.append(result[i]).append(' ');
			sb.append('\n');
			return;
		}

		for (int num : nums) {
			result[idx] = num;
			perm(idx + 1);
		}
	}
}
