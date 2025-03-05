## DFS & BFS

### DFS (Depth-First Search, 깊이 우선 탐색)

#### DFS란?
DFS(깊이 우선 탐색)는 그래프 탐색 알고리즘 중 하나로, 한 노드에서 출발하여 가능한 한 깊이 있는 경로를 탐색한 후, 더 이상 탐색할 수 없을 때 이전 분기로 돌아와 다른 경로를 탐색하는 방식이다. 즉, 한 경로를 끝까지 탐색한 후, 다른 경로를 탐색하는 방식이다.

#### DFS의 특징
- 한 번에 한 가지 선택만 하고 끝까지 탐색한 후 되돌아온다 (백트래킹).
- 모든 경우를 확인하기 때문에 시간이 오래 걸릴 수 있다.
- 재귀 함수 또는 스택을 활용하여 구현할 수 있다.
- 완전 탐색이 필요할 때 주로 사용된다 (예: 미로 찾기, 경로 탐색 등).

#### DFS의 구현 방법
1. **재귀 함수(Recursion)를 이용한 구현**  
   - 종료 조건을 설정하고, 재귀 호출을 통해 깊이 있는 탐색을 수행한다.
   - 방문한 노드를 체크하여 중복 방문을 방지한다.

2. **스택(Stack)을 이용한 구현**  
   - 명시적인 스택을 사용하여 DFS를 수행한다.
   - 방문해야 할 노드를 스택에 넣고, 하나씩 꺼내면서 탐색한다.

---

## DFS & BFS구현

### **DFS (깊이 우선 탐색)**

### **구현 방법**
- **스택(Stack)** 을 사용하여 탐색을 진행함.
- 한 경로를 끝까지 탐색한 후, 다른 경로를 탐색.
- `visited` 배열을 활용하여 중복 탐색 방지.
- 목표 노드에 도달하면 최소 촌수를 갱신.

```java
private static int dfs(int[][] family, boolean[] visited, int start, int target) {
		// TODO Auto-generated method stub
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { start, 0 });
		visited[start] = true;

		while (!stack.isEmpty()) {
			int[] temp = stack.pop();
			int num = temp[0];
			int depth = temp[1];

			if (num == target) {
				return depth;
			}

			for (int i = 1; i < family.length; i++) {
				if (family[num][i] == 1 && !visited[i]) {
					visited[i] = true;
					stack.push(new int[] { i, depth + 1 });
				}
			}
		}
		return -1;
	}

```
---
## **BFS (너비 우선 탐색)**
### **구현 방법**
- **큐(Queue)** 를 활용하여 너비 우선 탐색을 진행함.
- 시작 노드부터 가까운 노드 순으로 탐색.
- `visited` 배열을 활용하여 중복 방문 방지.
- 목표 노드에 도달하면 탐색을 종료하고 촌수를 반환.

```java
static int bfs(int start, int target) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];

    queue.add(new int[]{start, 0});
    visited[start] = true;

    while (!queue.isEmpty()) {
        int[] temp = queue.poll();
        int num = temp[0];   // 현재 노드
        int depth = temp[1]; // 촌수

        if (num == target) return depth; // 목표 인물 도달 시 촌수 반환

        for (int i = 1; i <= n; i++) {
            if (family[num][i] == 1 && !visited[i]) {
                visited[i] = true;
                queue.add(new int[]{i, depth + 1});
            }
        }
    }
    return -1; // 목표에 도달할 수 없는 경우
}
```
---

#### BFS의 특징
- 모든 경우를 동시에 고려하면서 탐색을 진행한다.
- 최단 경로(Shortest Path) 문제에 적합하다 (예: 미로 문제에서 가장 빠른 길 찾기).
- 큐(Queue)를 활용하여 구현한다.
- 탐색 과정에서 방문 체크를 위한 시간 배열을 활용할 수 있다.

#### BFS의 구현 방법
1. **큐(Queue)를 이용한 구현**  
   - 시작 노드를 큐에 삽입하고 방문 처리한다.
   - 큐에서 노드를 하나씩 꺼내면서 해당 노드의 인접한 노드를 큐에 삽입한다.
   - 모든 노드를 탐색할 때까지 반복한다.

2. **시간을 체크하는 방식**  
   - 최단 경로 문제에서 각 노드에 도달하는 시간을 기록한다.
   - 새로운 노드를 방문할 때, 기존보다 더 빠른 시간이면 갱신한다.

---

### DFS vs BFS 비교
|  비교 항목  | DFS (깊이 우선 탐색) | BFS (너비 우선 탐색) |
|------------|-----------------|-----------------|
| **탐색 방식** | 한 경로를 끝까지 탐색 후 되돌아옴 | 가까운 노드부터 탐색 |
| **사용 자료구조** | 재귀(스택) | 큐(Queue) |
| **시간 복잡도** | O(V + E) | O(V + E) |
| **경로 탐색** | 모든 경로를 탐색할 때 적합 | 최단 경로 탐색에 유리 |
| **사용 예시** | 백트래킹, 퍼즐 풀이, 조합 탐색 | 미로 찾기, 최단 거리 문제 |

DFS와 BFS는 각각 다른 장점이 있으므로, 문제의 성격에 맞게 선택하는 것이 중요하다.  
필요한 구현 코드가 있으면 요청하면 된다.

