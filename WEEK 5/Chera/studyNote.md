## 1. DFS
- 자기 자신을 호출하는 순환 알고리즘의 형태를 지님.
- 더이상 갈 곳이 없으면 백 트래킹 하여 다시 돌아감.
- 스택과 재귀 사용해서 구현하고 모든 노드를 방문하고자 할 때 사용됨
- BFS 보다 구현은 간단하지만 느림


```java
	// dfs, 재귀, 인접 행렬, i 정점부터 시작한다.    
    public static void dfs(int i) {		
        visit[i] = true;  // 노드 중복 접근 방지를 위한 방문 체크 배열. (boolean)		
        System.out.print(i + " ");		        // j는 dfs 배열의 새로운 분기를(int)		
        for(int j=1; j<n+1; j++) {  			
            if(map[i][j] == 1 && visit[j] == false) {				
                dfs(j);			
            }		
        }	
    }
    
```

## 2. BFS
- 재귀적으로 동작하지 않고 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 큐를 사용함.
- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하기 때문에 두 노드 사이의 최단 경로를 찾을 때 주로 사용함

**DFS는 '깊게' BFS는 '넓게' 탐색함**

```java
	// bfs, q사용, 인접행렬, i 정점부터 시작한다.	
    public static void bfs(int i) {		
        Queue<Integer> q = new LinkedList<>();		
        q.offer(i);		
        visit[i] = true; // 노드 중복 접근 방지를 위한 방문 체크 배열.(boolean)				
        while(!q.isEmpty()) {			
            int temp = q.poll();			
            System.out.print(temp + " ");			
            for(int j=1; j<n+1; j++) {				
                if(map[temp][j] == 1 && visit[j] == false) {					
                    q.offer(j);					
                    visit[j] = true;				
                }			
            }
                    		
        }	
    }

```