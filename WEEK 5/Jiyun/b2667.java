// 문제: 백준 2667번 단지번호붙이기
// 메모리: 14172 KB
// 시간: 104 ms

import java.io.*;
import java.util.*;

class Position {
	int row;
	int col;

	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class b2667 {
	static int n;
	static boolean[][] visited;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 맵 생성
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				if (input.charAt(j) == '1')
					map[i][j] = true;
			}
		}

		// 풀이 시작
		List<Integer> house = new ArrayList<>();
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 집이 존재하고, 아직 방문하지 않았으면
				if (map[i][j] && !(visited[i][j]))
					house.add(BFS(i, j));
			}
		}

		// 출력
		Collections.sort(house);
		sb.append(house.size()).append('\n');
		for (int h : house)
			sb.append(h).append('\n');
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// 현재 단지에 속해있는 집 개수를 리턴
	static int BFS(int r, int c) {
		Deque<Position> queue = new ArrayDeque<>();
		int cnt = 0;

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		queue.add(new Position(r, c));
		visited[r][c] = true;
		cnt++;

		while (!(queue.isEmpty())) {
			Position pos = queue.remove();

			for (int d = 0; d < 4; d++) {
				int nr = pos.row + dr[d];
				int nc = pos.col + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;

				if (map[nr][nc] && !(visited[nr][nc])) {
					queue.add(new Position(nr, nc));
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}
}
