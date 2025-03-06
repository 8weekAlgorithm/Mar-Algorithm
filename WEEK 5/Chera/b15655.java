/**
 * 문제 : 백준 15655번 N과 M (6)
 * 메모리 : 15804KB
 * 시간 : 116ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15655 {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sb = new StringBuilder();
		result = new int[M];
		Arrays.sort(arr);
		combi(0,0);
		System.out.println(sb.toString().trim());
		
	}

	static void combi(int start, int depth) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<N; i++) {
			result[depth] = arr[i];
			combi(i+1, depth+1);
		}
	}
}
