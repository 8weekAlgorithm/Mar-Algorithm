// 문제: 백준 15655번 문제제목 : 미로 탐색
// 링크: https://www.acmicpc.net/problem/2178
// 시간: 120ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

	static StringBuilder sb;
	// 상하좌우 이동 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	/* count : 칸 이동거리 저장 배열
	 * maze : 미로 입력값 배열
	 * visited : 방문 체크 배열
	 * */
	static int[][] count;
	static int[][] maze;
	static int n, m;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		count = new int[n][m];
		visited = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < m; c++) {
				maze[r][c] = str.charAt(c) - '0';
			}
		}
		sb.append(bfs(0, 0));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static int bfs(int x, int y) {
		/* BFS 동작원리
		 * 1. 방문 체크
		 * 2. 큐를 생성하여 처음 노드 삽입
		 * 3. 큐가 빌 때까지 작업 진행
		 * - 큐 안에 있는 앞 내용물을 뽑고, 인접 그래프를 반복문으로 돌면서 나와 연결된 노드들을 큐에 삽입함
		 * ※ 단, 방문을 했는지 확인 필요!
		 * */
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		count[x][y] = 1; //첫 요소 칸 거리 : 1
		visited[x][y] = true; //첫 요소 방문 체크
		
		while (!queue.isEmpty()) {
			//queue의 첫번째 값을 뽑아냄
			int[] position = queue.poll();
			int bx = position[0];
			int by = position[1];

			//원하는 위치에 도착 시 거리값 반환
			if (bx == n - 1 && by == m - 1) {
				return count[bx][by];
			}

			for (int d = 0; d < 4; d++) {
				int nx = bx + dr[d];
				int ny = by + dc[d];
				
				// 미로를 벗어나거나, 미로의 값이 0이거나, 이미 방문했다면 탐색하지 않음
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}

				//델타 탐색을 통해 이동한 좌표를 큐에 넣어줌(원래 위치에서 이동한 좌표)
				queue.add(new int[] { nx, ny });
				//이동 성공 시 거리칸 1 증가
				count[nx][ny] = count[bx][by] + 1;
				visited[nx][ny] = true; //방문처리
			}
		}
		return -1;
	}
}
