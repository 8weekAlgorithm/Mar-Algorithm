/**
 * 문제 : 백준 13305번 주유소
 * 메모리 : 35268KB
 * 시간 : 360ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b13305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] len = new int[N - 1];
		int[] node = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		st.nextToken();

		long cost = 0;
		long min = node[0];

		for (int i = 0; i < N - 1; i++) {

			if (node[i] < min) {
				min = node[i];
			}
			cost += len[i] * min;
		}

		System.out.println(cost);

	}

}
