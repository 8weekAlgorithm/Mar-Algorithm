// 문제: 15661 링크와 스타트 
// 메모리: 15436 KB
// 시간: 304 ms

import java.io.*;
import java.util.*;

public class b15661 {
	static int N;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 비트마스킹 부분집합
		for (int i = 0; i < (1 << (N - 1)); i++) {
            if (answer == 0)
                break;
			calc(i);            
        }

		System.out.println(answer);
	}

	static void calc(int teamS) {

		// 하나도 선택되지 않았거나, 모두 선택된 경우 패스
		if (teamS == 0 || teamS == (1 << N) - 1)
			return;

		int START = 0, LINK = 0;

		// 각 팀의 능력치 계산
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {

				if ((teamS & (1 << i)) != 0 && (teamS & (1 << j)) != 0)
					START += map[i][j] + map[j][i];

				if ((teamS & (1 << i)) == 0 && (teamS & (1 << j)) == 0)
					LINK += map[i][j] + map[j][i];
			}
		}
		answer = Math.min(answer, Math.abs(START - LINK));
	}
}