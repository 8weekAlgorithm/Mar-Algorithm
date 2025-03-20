// 문제: 18429 근손실
// 메모리: 14236 KB
// 시간: 112 ms

import java.io.*;
import java.util.*;

public class b18429 {
	static int N, K;
	static int[] add;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		add = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			add[i] = Integer.parseInt(st.nextToken());

		answer = 0;
		visited = new boolean[N];
		perm(0, 0); // 순열 활용
		System.out.println(answer);
	}

	static void perm(int depth, int weight) {

		if (depth == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			// 중량이 마이너스로 떨어지면 백트래킹
			if (weight + add[i] - K < 0)
				continue;

			visited[i] = true;
			perm(depth + 1, weight + add[i] - K);
			visited[i] = false;
		}
	}
}
