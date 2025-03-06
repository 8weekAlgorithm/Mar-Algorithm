/**
 * 문제 : 백준 15663번 N과 M (9)
 * 메모리 : 28340KB
 * 시간 : 244ms
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15663 {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		result = new int[M];
		combi(0);
		System.out.println(sb.toString().trim());
	}

	static void combi(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for (int i = 0; i < N; i++) {
			if (prev!= arr[i]&& !visited[i]) {
				result[depth] = arr[i];
				visited[i] = true;
				
				combi(depth + 1);
				prev = arr[i];
				visited[i] = false;
			}
		}
	}

}
