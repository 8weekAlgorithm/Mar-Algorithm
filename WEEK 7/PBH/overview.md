# 백트래킹, 비트마스킹

### 💡 필수 내용

- **백트래킹 (Backtracking)**
  + 가능한 모든 경우를 탐색하되, 유망하지 않은 경우는 가지치기하여 탐색을 줄이는 방식

- **비트마스킹 (Bitmasking)**
  + 정수를 비트 단위로 표현해 집합 연산을 수행하는 기법
  + 메모리를 절약하면서 연산 속도를 높일 수 있다


<br/>

### ❓ 유용한 내용

- DFS vs 백트래킹

  + DFS: 단순한 깊이 우선 탐색으로 조건 없이 모든 경우를 탐색
  + 백트래킹: DFS의 한 종류이지만, 가지치기를 통해 탐색 범위를 줄임

- 비트마스킹으로 방문 상태 관리하기
  +  기존 배열 방식 : `boolean[] visited = new boolean[4];`
  
  +  비트마스킹 방식 : `int visited = 0`
       +  초기 : `visited` = 0b0000
       +  2번 노드 방문 : `visited | (1 << 2)` = 0b0100
       +  2번 노드 해제 : `visited & ~(1 << 2)` = 0b0000
       +  방문 확인 : `(visited & (1 << 2)) != 0`



<br/>


### 📂 기본 문제

- 백트래킹 > 실버 3 | [근손실](https://www.acmicpc.net/problem/18429)
- 비트마스킹 > 실버 5 | [집합](https://www.acmicpc.net/problem/11723)

<br/>

### 📂 응용 문제

- 비트마스킹
  - 실버 4 | [비트가 넘쳐흘러](https://www.acmicpc.net/problem/17419)
  - 실버 2 | [기차가 어둠을 헤치고 은하수를](https://www.acmicpc.net/problem/15787)

- 비트마스킹 + 백트래킹
  - 골드 5 | [링크와 스타트](https://www.acmicpc.net/problem/15661)
  - 골드 4 | [스도쿠](https://www.acmicpc.net/problem/2239)

<br/>