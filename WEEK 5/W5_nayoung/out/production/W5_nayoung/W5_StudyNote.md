# 그래프, DFS, BFS 정리

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

```java
// 재귀 함수(Recursive Function)를 이용한 DFS (깊이 우선 탐색)
void DFS(int node) {

  // 현재 노드를 방문했음을 표시
  visited[node] = true;

  // 현재 방문한 노드를 출력 (탐색 순서 확인)
  System.out.print(node + " -> ");

  // 현재 노드와 연결된 모든 자식 노드(childNode)를 순회
  for(int childNode : graph[node]) { //graph는 보통 인접 리스트(LinkedList 또는 ArrayList)를 사용

    // 만약 해당 자식 노드를 방문하지 않았다면, 재귀 호출하여 탐색 진행
    if(!visited[childNode]) {
      DFS(childNode); // 재귀적으로 자식 노드를 탐색
    }
  }
}

```

```java
// 스택(Stack)을 이용한 DFS (깊이 우선 탐색) 구현
void DFS(int start) {
  // 스택을 생성하여 DFS를 수행할 노드를 저장
  Stack<Integer> stack = new Stack<>();

  // 시작 노드를 스택에 추가하고 방문 처리
  stack.add(start);
  System.out.print(start + " -> ");
  visited[start] = true;

  // 스택이 비어 있지 않은 동안 반복 (탐색할 노드가 남아 있는 경우)
  while(!stack.isEmpty()) {
    // 스택의 최상단 노드를 확인 **(pop하지 않고 peek만 함)**
    int curr = stack.peek();

    boolean hasNext = false; // 인접한 방문하지 않은 노드가 있는지 확인하는 변수

    // 현재 노드의 인접 노드(다음노드)를 확인
    for(int next : graph[curr]) {
      if(!visited[next]) { // 방문하지 않은 인접 노드가 있다면
        visited[next] = true; // 방문 표시
        System.out.print(next + " -> "); // 방문한 노드 출력
        hasNext = true; // 방문할 인접 노드가 존재함을 표시
        stack.add(next); // 스택에 인접 노드를 추가
        break; // 하나의 노드만 방문한 후 반복문 종료 (깊이 우선 탐색)
      }
    }

    // 방문할 인접 노드가 없으면 스택에서 현재 노드를 제거 (백트래킹)
    if(!hasNext) stack.pop();
  }
}

```

### 너비 우선 탐색 (BFS, Breadth-First Search)

: 최대한 넓게 이동한 다음, 더 이상 갈 수 없을 때 아래로 이동

- 임의의 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법으로, 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점은 나중에 방문하게 된다.
- 주로 두 노드 사이의 최단 경로를 찾고 싶을 때 활용
- 큐를 이용해서 구현

```java
//🔹 BFS 핵심 개념 정리

//1️⃣ 큐(Queue)를 사용해서 FIFO(First-In, First-Out) 방식으로 탐색
//2️⃣ 현재 노드를 꺼내고(poll) 인접 노드를 큐에 넣음(add)
//3️⃣ 이미 방문한 노드는 다시 방문하지 않도록 visited 배열 사용

// BFS (너비 우선 탐색) 알고리즘 구현
void BFS(int start) {
  //탐색을 위한 Queue 생성 (FIFO 구조)
  Queue<Integer> q = new LinkedList<>();

  //시작 노드를 큐에 추가하고 방문 처리
  q.add(start);
  visitied[start] = true;

  //큐가 빌 때까지 반복
  while (!q.isEmpty()) {
    //큐에서 현재 노드(curr) 꺼내기 (poll: 첫 번째 요소 반환 후 제거)
    int curr = q.poll();

    //현재 노드를 출력 (탐색 순서 확인용)
    System.out.print(curr + " -> ");

    //현재 노드와 연결된 모든 인접 노드를 순회
    for (int next : graph[curr]) {
      //방문하지 않은 노드라면 큐에 추가하고 방문 처리
      if (!visitied[next]) {
        q.add(next);
        visitied[next] = true;
      }
    }
  }
}

```

### DFS와 BFS를 활용한 문제 유형/응용

1. 그래프의 모든 정점을 방문해야 하는 경우
    - 둘 중 편한 것을 사용
2. 경로의 특징을 저장해둬야 하는 경우
    
    ex) 각 정점에 숫자가 적혀있고 a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안되는 경우
    
    - DFS 사용 (BFS는 경로의 특징을 저장할 수 X)
3. 최단거리를 구해야 하는 경우 
    
    ex) 미로찾기
    
    - 둘 다 사용가능하지만 BFS가 유리.
    - BFS는 현재 노드에서 가까운 곳부터 찾기 때문에 경로탐색 시 먼저 찾아지는 해답이 곧 최단거리다!
4. 검색 대상 그래프가 정말 크다면 DFS를 고려
5. 검색 대상 규모가 크지 않고, 검색 시작 지점으로부터 원하는 대상이 별로 멀지 않다면 BFS

---

참고자료

- 그래프: [https://velog.io/@kwontae1313/트리와-그래프에-대해-알아보자](https://velog.io/@kwontae1313/%ED%8A%B8%EB%A6%AC%EC%99%80-%EA%B7%B8%EB%9E%98%ED%94%84%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)
- 개념: [https://devuna.tistory.com/32](https://devuna.tistory.com/32)
- 구현방법: [https://www.youtube.com/watch?v=_hxFgg7TLZQ&t=608s](https://www.youtube.com/watch?v=_hxFgg7TLZQ&t=608s)
- 코드: [https://velog.io/@jeongbeom4693/Java-DFS-BFS](https://velog.io/@jeongbeom4693/Java-DFS-BFS)