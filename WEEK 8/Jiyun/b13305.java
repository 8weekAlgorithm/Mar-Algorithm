// 문제: 13305 주유소
// 메모리: 36320 KB
// 시간: 384 ms

import java.io.*;
import java.util.*;

public class b13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[] road = new long[N - 1];
		long[] gasCost = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			road[i] = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			gasCost[i] = Long.parseLong(st.nextToken());

		// 풀이 시작
		long bestCost = Long.MAX_VALUE;
		long sum = 0;

		for (int i = 0; i < N - 1; i++) {

			// 최소 비용으로 갱신
			if (bestCost > gasCost[i])
				bestCost = gasCost[i];

			sum += bestCost * road[i];
		}

		System.out.println(sum);
	}
}
