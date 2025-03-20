// 문제: 백준 18429번 
// 문제제목 : 근손실
// 링크: https://www.acmicpc.net/problem/18429
// 메모리 : 14224KB
// 시간: 108ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18429 {
	static StringBuilder sb;
	static int[] kit;
	static int N, K;
	static int count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 운동 키트 개수
		K = Integer.parseInt(st.nextToken()); // 중량 감소량
		kit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		visited = new boolean[N];
		training(0, 500);

		System.out.println(count);
	}

	static void training(int n, int weight) {
		// 중간에 중량이 500밑으로 떨어지면 끝내버림
		if (weight < 500) {
			return;
		}
		// N일이 지나면 성공 카운트 올리고 끝
		if (n == N) {
			count++;
			return;
		}
        // 기존무게-K+운동키트로 재귀진행
        // 백트래킹 구현(visited)
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				training(n + 1, weight - K + kit[i]);
				visited[i] = false;
			}
		}
	}

}