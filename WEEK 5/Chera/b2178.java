/**
 * 문제 : 백준 2178번 미로 탐색
 * 메모리 : 16524KB
 * 시간 : 156ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
	static int N;
	static int M;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.valueOf(str[j]);
			}
		}
		bfs();
		System.out.println(graph[N-1][M-1]);

	}

	static void bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> qu = new LinkedList<>();
		
		qu.add(new Point(0, 0));
		visited[0][0] = true;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		while (!qu.isEmpty()) {
			Point n = qu.poll();

			for (int k = 0; k < dx.length; k++) {
				int x = n.x + dx[k];
				int y = n.y + dy[k];

				if (x < 0 || y < 0 || x >= N || y >= M) {
					continue;
				}

				if (!visited[x][y] && graph[x][y] == 1) {
					graph[x][y] = graph[n.x][n.y] + 1;
					visited[x][y] = true;
					qu.add(new Point(x, y));
					
				}
			}
		}
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
