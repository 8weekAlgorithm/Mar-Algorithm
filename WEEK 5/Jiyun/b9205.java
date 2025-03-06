// 문제: 백준 9205번 맥주 마시면서 걸어가기
// 메모리: 15112 KB
// 시간: 124 ms

import java.io.*;
import java.util.*;

class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class b9205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 입력 받기
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			// location (0 집) (1~N 편의점) (N+1 축제)
			Position[] loc = new Position[N + 2];

			st = new StringTokenizer(br.readLine());
			loc[0] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				loc[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			loc[N + 1] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 풀이 시작 (BFS)
			boolean[] visited = new boolean[N + 2];
			Queue<Integer> queue = new ArrayDeque<>();

			boolean happy = false;
			queue.add(0); // 집에서 출발
			visited[0] = true;

			while (!queue.isEmpty()) {
				int node = queue.remove();

				// 페스티벌에 도착했으면 종료
				if (node == N + 1) {
					happy = true;
					break;
				}

				// 방문하지 않았고, 1000m 이내면 큐에 추가
				for (int i = 1; i < N + 2; i++) {
					if (visited[i])
						continue;

					int x = Math.abs(loc[node].x - loc[i].x);
					int y = Math.abs(loc[node].y - loc[i].y);

					if (x + y <= 1000) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}

			// 출력
			if (happy)
				sb.append("happy");
			else
				sb.append("sad");
			sb.append('\n');
		}
		br.close();

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
