```markdown
    1
   / \
  2   3
 / \   \
4   5   6

DFS : 1-2-4-5-3-6
BFS : 1-2-3-4-5-6
```

## DFS(깊이 우선 탐색)

- 스택(Stack) 또는 재귀(Recursion)를 이용해서 탐색.
- 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 곳이 없으면 되돌아오는 방식(백트래킹).
- **탐색 순서가 깊게 들어가는 것이 특징**.
- **시간 복잡도: $O(V+E)$** (V: 정점 개수, E: 간선 개수)

```java
import java.util.*;

public class MazeDFS {
    static int[][] maze = {
        {0, 1, 0, 0},
        {0, 1, 0, 1},
        {0, 0, 0, 1},
        {1, 1, 0, 0}
    };
    static int N = 4, M = 4;
    static boolean[][] visited = new boolean[N][M];

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        boolean result = dfs(0, 0);
        System.out.println("미로 탈출 가능? " + result);
    }

    static boolean dfs(int x, int y) {
        // 범위를 벗어나거나 벽이거나 방문한 곳이면 false
        if (x < 0 || y < 0 || x >= N || y >= M || maze[x][y] == 1 || visited[x][y]) {
            return false;
        }

        // 도착점 도달하면 true
        if (x == N - 1 && y == M - 1) {
            return true;
        }

        // 방문 처리
        visited[x][y] = true;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (dfs(nx, ny)) {
                return true; // 도착 가능하면 true 반환
            }
        }

        return false; // 모든 방향 탐색 후 실패하면 false
    }
}

```

## BFS(너비 우선 탐색)

- 큐(Queue)를 이용해서 탐색.
    
     ※ 왜 BFS에서 큐를 사용함?
    
    - BFS는 가까운 노드부터 차례대로 탐색하는 방식임
    - 이 때 탐색 순서를 유지하려면 선입선출(FIFO) 구조가 필요함
    - 즉, 먼저 방문한 노드의 이웃 노드를 먼저 탐색하기 위해 큐를 사용함
- 현재 노드에서 가까운 노드부터 차례로 방문.
- **최단 경로 문제에서 자주 사용됨**.
- **시간 복잡도: $O(V+E)$**

### BFS 예제 1 : 미로 최단 거리 찾기

```java
import java.util.*;

public class MazeBFS {
    static int[][] maze = {
        {1, 1, 0, 1},
        {0, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 1}
    };
    static int N = 4, M = 4;
    static int[][] dist = new int[N][M]; // 거리 저장 배열

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int result = bfs(0, 0);
        System.out.println("최단 거리: " + result);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        dist[x][y] = 1; // 시작점 거리 1

        while (!queue.isEmpty()) {
            int[] point = queue.poll(); // 큐에서 꺼냄
            int cx = point[0];
            int cy = point[1];

            // 도착점 도달하면 거리 반환
            if (cx == N - 1 && cy == M - 1) {
                return dist[cx][cy];
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어나거나 벽이거나 방문한 곳이면 무시
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || maze[nx][ny] == 0 || dist[nx][ny] > 0) {
                    continue;
                }

                // 큐에 추가하고 거리 갱신
                queue.add(new int[]{nx, ny});
                dist[nx][ny] = dist[cx][cy] + 1;
            }
        }

        return -1; // 도착 불가능한 경우
    }
}

```