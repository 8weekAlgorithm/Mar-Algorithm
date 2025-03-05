// 문제: 백준 2178번 미로 탐색
// 메모리: 14720 KB
// 시간: 112 ms

import java.io.*;
import java.util.*;

public class B2178 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dxy = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; // 우, 하, 좌, 상
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 1}); // {x, y, depth}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int depth = now[2];

            // 도착 지점에 도달하면 depth 반환 (최단 거리)
            if (x == N - 1 && y == M - 1) return depth;

            for (int i = 0; i < 4; i++) {
                int nx = x + dxy[i][0];
                int ny = y + dxy[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) { // 이동 가능 && 방문 안 한 곳
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, depth + 1});
                    }
                }
            }
        }
        return -1; // 경로가 없는 경우 (문제 조건 상 이런 경우는 없음)
    }
}