// 문제: 1931 회의실 배정
// 메모리: 44444 KB
// 시간: 488 ms

import java.io.*;
import java.util.*;

public class b1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작
			meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료
		}

		// 종료시간을 기준으로 정렬 + 종료시간이 같으면 시작시간으로 정렬
		Arrays.sort(meetings, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});

		int current = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (meetings[i][0] < current)
				continue;
			current = meetings[i][1];
			answer += 1;
		}

		System.out.println(answer);
	}
}
