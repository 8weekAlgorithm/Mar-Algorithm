/**
 * 문제 : 백준 2644번 촌수계산
 * 메모리 : 14160KB
 * 시간 : 104ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2664 {
    static int[][] graph;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 노드 수
        int[] target = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p][c] = graph[c][p] = 1;
        }

        visited = new boolean[N + 1];
        System.out.println(bfs(target[0], target[1]));
    }

    static int bfs(int start, int end) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{start, 0}); // (현재 노드, 촌수)

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int node = curr[0];
            int depth = curr[1];

            if (node == end) {
                return depth; // 찾으면 촌수 반환
            }

            visited[node] = true;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    qu.add(new int[]{i, depth + 1});
                }
            }
        }

        return -1; // 연결되지 않은 경우
    }
}
