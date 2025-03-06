// 문제: 백준 2178번 미로 탐색
// 메모리: 14456 KB
// 시간: 112 ms

import java.io.*;
import java.util.*;

class Node {
	int row;
	int col;
	int cnt;

	Node(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}
}

public class b2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int ROW = Integer.parseInt(st.nextToken());
		int COL = Integer.parseInt(st.nextToken());

		// 맵 생성
		boolean[][] map = new boolean[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for (int j = 0; j < COL; j++)
				if (input.charAt(j) == '1') {
					map[i][j] = true;
				}
		}

		// 풀이 시작
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		boolean[][] visited = new boolean[ROW][COL];
		Deque<Node> queue = new ArrayDeque<>();
		queue.addLast(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!(queue.isEmpty())) {
			Node node = queue.removeFirst();

			// (N, M)에 도착하면 종료
			if (node.row == ROW - 1 && node.col == COL - 1) {
				System.out.println(node.cnt);
				break;
			}

			// 4방향 탐색 후 이동 가능하면 큐에 추가
			for (int d = 0; d < 4; d++) {
				int nr = node.row + dr[d];
				int nc = node.col + dc[d];

				if (nr < 0 || nc < 0 || nr >= ROW || nc >= COL)
					continue;

				if (map[nr][nc] && !(visited[nr][nc])) {
					queue.addLast(new Node(nr, nc, node.cnt + 1));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
