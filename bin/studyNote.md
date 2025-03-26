# DFS & BFS (깊이 우선 탐색 & 너비 우선 탐색)

## 1. DFS(Depth-First Search) - 깊이 우선 탐색
### 특징
- 최대한 깊숙이 들어가면서 탐색하는 방식
- 스택(Stack) 또는 재귀(Recursive)로 구현 가능
- 그래프가 깊은 경우 재귀 호출이 많아질 수 있음 (→ 스택 오버플로우 주의)
- 백트래킹(Backtracking)과 함께 자주 사용됨

### 동작 방식
1. 현재 노드 방문 처리
2. 연결된 노드 중 방문하지 않은 노드로 이동 (있으면 계속 이동)
3. 더 이상 갈 곳이 없으면 이전 노드로 돌아감 (백트래킹)
4. 모든 노드를 방문할 때까지 반복

### DFS 예제 코드 (Java)
```java
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프
        }

        dfs(1); // 1번 노드부터 탐색 시작
    }
}
```
---
## 2. BFS(Breadth-First Search) - 너비 우선 탐색
### 특징
- 가까운 노드부터 탐색하는 방식
- 큐(Queue)를 이용하여 구현
- 최단 거리 문제에서 많이 사용됨

### 동작 방식
1. 시작 노드를 큐에 넣고 방문 처리
2. 큐에서 노드를 하나씩 꺼내 연결된 노드 중 방문하지 않은 노드를 모두 큐에 추가
3. 큐가 빌 때까지 반복

### BFS 예제 코드 (Java)
```java
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프
        }

        bfs(1); // 1번 노드부터 탐색 시작
    }
}
```

---
## 3. DFS vs BFS 차이점
|  | DFS | BFS |
|---|---|---|
| 자료구조 | 스택(Stack) / 재귀(Recursive) | 큐(Queue) |
| 탐색 방식 | 깊이 우선 | 너비 우선 |
| 최단 경로 | 아님 | 최단 거리 찾기 가능 |
| 공간 복잡도 | 낮음(노드가 많을 때 유리) | 높음(노드가 많으면 큐가 커짐) |
| 활용 | 백트래킹, 경로 탐색 | 최단 경로, 네트워크 탐색 |

---
## 4. 언제 DFS? 언제 BFS?
- **최단 경로 찾기 → BFS**  
  → BFS는 먼저 방문한 것이 가장 가까운 거리이므로 최단 거리 문제에 유리  
- **백트래킹이나 모든 경우 탐색 → DFS**  
  → 재귀를 이용한 깊이 우선 탐색이 더 자연스러움  
- **그래프 크기가 크고 메모리 제한이 적다면 → BFS 비추천**  
  → BFS는 큐를 많이 쓰기 때문에 메모리를 많이 차지함  
- **그래프 깊이가 깊다면 → DFS 비추천**  
  → 재귀 호출이 많아지면 스택 오버플로우 발생 가능  

---