// 문제: 백준 2667번 단지번호붙이기
// 메모리: 15900 KB
// 시간: 124 ms

import java.io.*;
import java.util.*;

public class B2667 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dxy = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; // 우, 하, 좌, 상
    static List<Integer> sizes = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int complexCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    complexCount++;
                    sizes.add(dfs(i, j));
                }
            }
        }

        Collections.sort(sizes); // 단지 크기 오름차순 정렬

        bw.write(complexCount + "\n");
        for (int size : sizes) {
            bw.write(size + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // 현재 위치 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dxy[i][0];
            int ny = y + dxy[i][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}