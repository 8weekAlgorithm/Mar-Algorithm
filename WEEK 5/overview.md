# 그래프 탐색 (BFS, DFS)

### 💡 필수 내용

- **DFS (Depth-First Search)**
  + 가능한 깊이 들어가며 탐색하는 방식
  + 스택(Stack) 또는 재귀(Recursion) 활용

- **BFS (Breadth-First Search)**
  + 인접한 노드를 모두 방문한 후 다음 깊이로 이동하는 방식
  + 큐(Queue) 활용


<br/>

### ❓ 유용한 내용

- ***이론적으로는…***

  + DFS로 풀 수 있는 문제는 BFS로 풀 수 있고, BFS로 풀 수 있는 문제는 DFS로 해결할 수 있다.

  + 하지만 시간 복잡도, 탐색 순서, 구현 편의성 때문에 문제 유형에 따라 더 유리한 탐색 방식이 존재한다.

  + Ex) 경로 탐색은 DFS, 최단 거리는 BFS

- DFS & BFS를 전부 이해했다면? ***심화 알고리즘!***

  + 다익스트라(Dijkstra) : 가중치 그래프에서 최단 경로 찾기
  + 위상 정렬(Topological Sort) : 방향 그래프를 특정 순서로 정렬
  + 최소 신장 트리(MST) : 모든 노드를 연결하는 최소 비용 트리


<br/>

### 📂 기본 문제

- 실버2 | [DFS와 BFS](https://www.acmicpc.net/problem/1260)

<br/>

 ### 📂 응용 문제

- 순열과 조합 (DFS)
  + 실버2 | [중복 있는 순열](https://www.acmicpc.net/problem/15665)
  + 실버2 | [중복 없는 순열](https://www.acmicpc.net/problem/15663)
  + 실버3 | [중복 없는 조합](https://www.acmicpc.net/problem/15655)

- DFS & BFS
  + 실버1 | [미로 탐색](https://www.acmicpc.net/problem/2178)
  + 실버1 | [단지번호붙이기](https://www.acmicpc.net/problem/2667)
  + 실버2 | [촌수계산](https://www.acmicpc.net/problem/2644)
  + 골드5 | [맥주 마시면서 걸어가기](https://www.acmicpc.net/problem/9205)  
