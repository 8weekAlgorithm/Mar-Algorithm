/**
 * 문제 : 백준 15665번 N과M (11)
 * 메모리 : 89712KB
 * 시간 : 400ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15665 {
	static int N;
	static int M;
	static int[] arr;
	static int[] res;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res = new int[M];

		sb = new StringBuilder();
		Arrays.sort(arr);
		combi(0);
		System.out.println(sb.toString().trim());
	}

	static void combi(int depth) {
		if (depth >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}

		int prev = -1;
		for (int i = 0; i < N; i++) {
			if (prev != arr[i]) {
				res[depth] = arr[i];
				combi(depth + 1);
				prev = arr[i];
			}

		}
	}

}
