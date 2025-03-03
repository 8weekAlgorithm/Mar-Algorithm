### 그래프

- 여러 개의 노드(node)와 이들을 연결하는 간선(Edge)으로 이루어진 자료구조
- 대표적인 비선형 자료구조로, 데이터 요소들이 계층적으로 연결되어 있다.

**그래프 중에서 방향성이 있는 비순환 그래프를 트리라고 한다.*

### 깊이 우선 탐색 (DFS, Depth-First Search)

: 최대한 깊이 내려간 뒤, 더이상 깊이 갈 곳이 없을 경우 옆으로 이동

- 임의의 노드에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기(branch)를 완벽하게 탐색하는 방식
- 모든 노드를 방문하고자 하는 경우에 활용
- BFS보다 좀 더 간단히 구현 가능하지만, BFS보다 검색 속도 자체는 느리다.
- 스택 또는 재귀함수로 구현

#### 예시 코드
```java
/* 인접 리스트 이용 */
class Graph {  
  private int V; // 그래프의 정점 개수를 저장하는 변수
  private LinkedList<Integer> adj[]; // 인접 리스트를 저장할 배열 선언
 
  // 그래프 생성자
  Graph(int v) {
      V = v; // 정점 개수 초기화
      adj = new LinkedList[v]; // 정점 개수만큼 인접 리스트 배열 생성
      
      // 모든 정점에 대해 빈 리스트를 생성 (초기화)
      for (int i=0; i<v; ++i)
          adj[i] = new LinkedList(); // 정점 i에 대한 빈 연결 리스트 할당
  }

  // 간선을 추가하는 메서드 (정점 v에서 정점 w로 가는 간선 추가)
  void addEdge(int v, int w) { 
      adj[v].add(w); // 정점 v의 인접 리스트에 정점 w 추가 (방향 그래프)
  }
 
  /* DFS에 의해 사용되는 함수 */
  void DFSUtil(int v, boolean visited[]) {
      // 현재 노드를 방문했다고 표시
      visited[v] = true;
      System.out.print(v + " "); // 방문한 노드 출력
 
      // 현재 노드와 연결된 모든 노드를 순회
      Iterator<Integer> it = adj[v].listIterator(); // 인접 리스트 순회할 반복자 생성
      while (it.hasNext()) { // 인접한 노드가 있는 동안 반복
          int n = it.next(); // 다음 인접 노드 가져오기
          
          // 만약 방문하지 않은 노드라면 DFS 재귀 호출
          if (!visited[n])
              DFSUtil(n, visited); // 방문하지 않은 경우 해당 노드를 시작 노드로 다시 DFS 실행
      }
  }
 
  /* DFS 탐색 시작 */
  void DFS(int v) {
      boolean visited[] = new boolean[V]; // 방문 여부를 저장하는 배열 (초기값은 false)
 
      // 주어진 시작 노드 v에서 DFS 탐색 시작
      DFSUtil(v, visited);
  }
}
```

### 너비 우선 탐색 (BFS, Breadth-First Search)

: 최대한 넓게 이동한 다음, 더 이상 갈 수 없을 때 아래로 이동

- 임의의 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법으로, 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점은 나중에 방문하게 된다.
- 주로 두 노드 사이의 최단 경로를 찾고 싶을 때 활용
- 큐를 이용해서 구현

#### 예시 코드
```java
// 그래프를 나타내는 클래스 정의
class Graph {  
  private int V; // 그래프의 정점 개수를 저장하는 변수
  private LinkedList<Integer> adj[]; // 인접 리스트를 저장할 배열 선언
 
  // 그래프 생성자
  Graph(int v) {
    V = v; // 정점 개수 초기화
    adj = new LinkedList[v]; // 정점 개수만큼 인접 리스트 배열 생성
    
    // 모든 정점에 대해 빈 리스트를 생성 (초기화)
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList(); // 정점 i에 대한 빈 연결 리스트 할당
  }

  // 간선을 추가하는 메서드 (정점 v에서 정점 w로 가는 간선 추가)
  void addEdge(int v, int w) { 
    adj[v].add(w); // 정점 v의 인접 리스트에 정점 w 추가 (방향 그래프)
  }

  /* BFS(너비 우선 탐색) */
  void BFS(int s) {  
    boolean visited[] = new boolean[V]; // 방문 여부를 체크하는 배열 (초기값은 false)
    LinkedList<Integer> queue = new LinkedList<Integer>(); // BFS에서 사용할 큐

    visited[s] = true; // 시작 정점 s를 방문한 것으로 표시
    queue.add(s); // 시작 정점을 큐에 삽입 (enqueue)
 
    while (queue.size() != 0) { // 큐가 비어있지 않으면 반복
      // 방문한 노드를 큐에서 꺼내(dequeue) 출력
      s = queue.poll(); 
      System.out.print(s + " "); 
 
      // 현재 노드 s와 인접한 모든 노드를 가져옴
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) { // 인접한 노드가 있는 동안 반복
        int n = i.next(); // 다음 인접 노드 가져오기

        // 방문하지 않은 노드라면 방문한 것으로 표시하고 큐에 추가
        if (!visited[n]) {
          visited[n] = true; // 방문 체크
          queue.add(n); // 큐에 삽입 (enqueue)
        }
      }
    }
  }
}

```

### DFS와 BFS를 활용한 문제 유형/응용

1. 그래프의 모든 정점을 방문해야 하는 경우
    - 둘 중 편한 것을 사용
2. 경로의 특징을 저장해둬야 하는 경우
    - ex) 각 정점에 숫자가 적혀있고 a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안되는 경우
    - DFS 사용 (BFS는 경로의 특징을 저장할 수 X)
3. 최단거리를 구해야 하는 경우 
    - ex) 미로찾기
    - 둘 다 사용가능하지만 BFS가 유리.
    - BFS는 현재 노드에서 가까운 곳부터 찾기 때문에 경로탐색 시 먼저 찾아지는 해답이 곧 최단거리다!
4. 검색 대상 그래프가 정말 크다면 DFS를 고려
5. 검색 대상 규모가 크지 않고, 검색 시작 지점으로부터 원하는 대상이 별로 멀지 않다면 BFS

---

참고자료

- [그래프(Graph)에 대해 알아보자](https://velog.io/@kwontae1313/%ED%8A%B8%EB%A6%AC%EC%99%80-%EA%B7%B8%EB%9E%98%ED%94%84%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)
- [[알고리즘]깊이우선탐색(DFS)과 너비우선탐색(BFS)](https://devuna.tistory.com/32)