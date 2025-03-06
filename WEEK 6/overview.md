# 집합, 해시, 이진 검색 트리

### 💡 필수 내용

- **집합 (Set)**
  + 중복을 허용하지 않고, 특정 원소가 있는지 빠르게 찾을 수 있는 구조

- **해시 (Hash)**
  + 데이터를 빠르게 저장하고 검색하기 위해 사용하는 기술

- **이진 검색 트리 (BST)**
  + 이진 트리의 한 종류
  + 배열, 리스트보다 탐색, 삽입, 삭제에 효율적

- **알아야 하는 클래스**
  + `HashSet`, `HashMap`
  + `TreeSet`, `TreeMap`


<br/>

### ❓ 유용한 내용

- 레드-블랙 트리 (Red-Black Tree)

  + 일반 BST는 한쪽으로 치우칠 경우 $O(N)$의 성능 저하가 발생할 수 있다
  + RBT는 균형을 유지하는 자체적인 규칙을 가진 BST으로, 탐색, 삽입, 삭제를 $O(log N)$으로 유지한다
  + `TreeSet`과 `TreeMap`가 RBT로 구현되어 있다

- 함께 알아두면 좋은 자료구조

  + `LinkedHashSet` : 입력 순서를 유지하면서 저장
  + `LinkedHashMap` : 입력 순서를 유지하면서 Key-Value 저장
  + `PriorityQueue` : 최솟값, 최댓값을 빠르게 찾아야 할 때 사용



<br/>



### 📂 기본 문제

- Map / 실버 4 | [나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620)
- Set / 실버 4 | [인사성 밝은 곰곰이](https://www.acmicpc.net/problem/25192)

<br/>

### 📂 응용 문제

- 실버 3 | [파일 정리](https://www.acmicpc.net/problem/20291)
- 실버 2 | [생태학](https://www.acmicpc.net/problem/4358)
- 실버 1 | [추월](https://www.acmicpc.net/problem/2002)
- 골드 5 | [정보 상인 호석](https://www.acmicpc.net/problem/22252)
- 골드 4 | [문제 추천 시스템 Version 1](https://www.acmicpc.net/problem/21939)

<br/>

*반드시 `HashSet`, `HashMap`, `TreeSet`, `TreeMap`을 활용하여 풀 것!*
