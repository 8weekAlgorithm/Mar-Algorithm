// 문제: 백준 11047번 
// 문제제목 : 동전 0
// 링크: https://www.acmicpc.net/problem/11047
// 메모리 : 14308KB
// 시간: 104ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
        // 동전 가치를 내림차순으로 정렬
		Arrays.sort(coin, Collections.reverseOrder());
		int count = 0;
        // K원을 넘을때까지 K/c 의 값을 누적으로 더하면서 동전 개수를 저장함
        // K원은 나머지 계산을 통해 갱신함
		for (int c : coin) {
			if (K >= c && K != 0) {
				count = count + K / c;
				K = K % c;
			}
		}
		System.out.println(count);
	}

}
