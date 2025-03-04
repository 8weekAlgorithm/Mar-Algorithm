# Graph

그래프는 정점(Vertex, 노드)과 간선(Edge)로 이루어진 자료구조이다.

## 방향 그래프

![방향 그래프](https://blog.kakaocdn.net/dn/b6W802/btrmForLO3w/3K1kuFoKrM3yZP83jUV19K/img.png)

그래프에서 간선(Edge)이 한쪽 방향으로만 갈 수 있는지, 양방향으로 갈 수 있는지에 따라 분류된다.

- **방향 그래프 (Diredted Graph)** : 간선이 한쪽 방향으로 연결되어, 특정 방향으로만 이동 가능하다.

- **무방향 그래프 (Undirected Graph)** : 간선이 양방향으로 연결되어, 한 정점에서 다른 정점으로 이동할 때 반대 방향으로도 갈 수 있다.

<br>

## 가중치 그래프

![가중치 그래프](https://res.cloudinary.com/dc0mjpwf8/image/upload/v1590076857/ArticleImages/Graph/weigh_Graph_xu1hjb.png)

그래프의 간선에 가중치(Weight)가 있는지에 따라 분류된다.

- **가중치 그래프 (Weighted Graph)** : 간선마다 가중치가 존재하는 그래프

- **비가중치 그래프 (Unweighted Graph)** : 모든 간선의 가중치가 동일한 그래프

<br>

## 연결 그래프

![연결 그래프](https://media.cheggcdn.com/media/546/546deafc-f763-4250-9f15-d600fa22e55a/phpOZYHkz.png)

그래프의 모든 정점이 연결되어 있는지에 따라 분류된다.

- **연결 그래프 (Connected Graph)** : 모든 정점이 적어도 하나의 간선으로 연결되어 있는 그래프
- **비연결 그래프 (Disconnected Graph)** : 일부 정점이 연결되지 않은 그래프


<br>
<br>
<br>

# DFS

깊이 우선 탐색(Depth-First Search)은 한 방향으로 깊게 탐색하다가 더 이상 갈 곳이 없으면 되돌아와서(백트래킹) 다른 경로를 탐색하는 방식이다.

### 동작 원리
- 시작 정점을 방문하고 방문 표시
- 방문한 정점에서 갈 수 있는 정점 중 가장 깊은 곳 우선 방문
- 더 이상 방문할 곳이 없으면 되돌아감
- 모든 정점을 방문할 때까지 반복

### 특징
- 시간 복잡도는 $O(V+E)$ (V: 정점 수, E: 간선 수)
- 재귀(호출 스택) 또는 스택 사용
- 특정 경로 찾기에 유리

### 구현

- 재귀
```java
    static void recursiveDFS(List<List<Integer>> graph, boolean[] visited, int node) {
        if (visited[node]) return; // 이미 방문한 경우 종료

        visited[node] = true;
        System.out.print(node + " ");

        for (int n : graph.get(node)) {
            if (!visited[n]) {
                recursiveDFS(graph, visited, n);
            }
        }
    }
```

- 스택
```java
    static void stackDFS(List<List<Integer>> graph, int nodes, int start) {

		boolean[] visited = new boolean[nodes + 1];
		Deque<Integer> stack = new ArrayDeque<>();

		stack.add(start);

		while (!(stack.isEmpty())) {
			int node = stack.removeLast();
			if (!(visited[node])) {
				visited[node] = true;
				System.out.print(node + " ");
			}

			for (int n : graph.get(node)) {
				if (!(visited[n])) {
					stack.addLast(n);
				}
			}
		}
	}
```


<br>
<br>
<br>

# BFS

너비 우선 탐색(Breadth-First Search)은 가까운 정점부터 탐색하는 방식이다.

### 동작 원리
- 시작 정점을 방문하고 큐에 넣음
- 큐에서 정점을 꺼내고, 인접한 정점들을 큐에 추가하며 방문 표시
- 모든 정점을 반복할 때까지 반복

### 특징
- 시간 복잡도는 $O(V+E)$ (V: 정점 수, E: 간선 수)
- 큐 사용
- 최단 거리 탐색에 유리 (비가중치 그래프)

### 구현
```java
    static void BFS(List<List<Integer>> graph, int nodes, int start) {
		boolean[] visited = new boolean[nodes + 1];
		Deque<Integer> queue = new ArrayDeque<>();

		queue.addLast(start);
		visited[start] = true;
		System.out.print(start + " ");	

		while (!queue.isEmpty()) {
			int node = queue.removeFirst();

			for (int n : graph.get(node)) {
				if (!(visited[n])) {
					queue.addLast(n);
					visited[n] = true;
					System.out.print(n + " ");
				}
			}	
		}
	}
```

<br>
<br>
<br>

# 응용 알고리즘
DFS, BFS 외에도 그래프를 탐색할 때 사용할 수 있는 알고리즘에는 다음이 있다.

### 최단 경로 알고리즘
DFS와 BFS는 비가중치 그래프의 최단 경로만 구할 수 있으므로, 가중치 그래프에서는 다음 알고리즘을 사용해야 한다.

- 다익스트라 알고리즘 (Dijkstra’s Algorithm) : 가중치가 양수인 그래프에서 최단 경로를 찾는 알고리즘

- 벨만-포드 알고리즘 (Bellman-Ford Algorithm) : 가중치가 음수인 간선이 있어도 사용할 수 있는 알고리즘

- 플로이드-워셜 알고리즘 (Floyd-Warshall Algorithm) : 모든 정점 간의 최단 경로를 구할 때 사용하는 알고리즘

### 최소 신장 트리 (MST, Minimum Spanning Tree)
모든 노드를 연결하는 최소 비용의 트리를 찾는 알고리즘이다.

- 크루스칼 알고리즘 (Kruskal’s Algorithm) : 간선을 정렬한 후 최소 비용 간선부터 선택하는 알고리즘

- 프림 알고리즘 (Prim’s Algorithm) : 정점 중심으로 최소 비용 간선을 선택하는 알고리즘