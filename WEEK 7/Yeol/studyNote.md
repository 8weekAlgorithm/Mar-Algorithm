# 백트래킹 (Backtracking) & 비트마스킹 (Bitmasking)

## 1. 백트래킹 (Backtracking)
백트래킹은 가능한 모든 경우의 수를 탐색하지만, 불필요한 경우(유망하지 않은 경우)를 미리 제외하여 탐색 속도를 최적화하는 기법이다.

### 📌 핵심 개념
- 기본적으로 **DFS(깊이 우선 탐색, Depth-First Search)**을 기반으로 동작함.
- 특정 조건을 만족하지 않는 경우, 즉시 탐색을 중단하고 이전 단계로 되돌아감(**Pruning, 가지치기**).
- 일반적으로 **재귀(Recursion)**를 사용하여 구현함.
- 대표적인 문제: **N-Queen, 부분 수열, 순열 & 조합, Sudoku 해결 등**

### 📌 예제: N-Queen 문제
```java
import java.io.*;

public class NQueen {
    static int N, count;
    static int[] board; // board[i] = j -> i번째 행의 퀸이 j번째 열에 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        count = 0;

        solve(0);
        System.out.println(count);
    }

    static void solve(int row) {
        if (row == N) { // 모든 퀸을 배치했다면
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col; // row 번째 행의 col 열에 퀸 배치
            if (isValid(row)) { // 유효하면 다음 행으로 이동
                solve(row + 1);
            }
        }
    }

    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[i] - board[row]) == row - i) {
                return false; // 같은 열 또는 대각선에 위치하는 경우
            }
        }
        return true;
    }
}
```

## 2. 비트마스킹 (Bitmasking)
비트마스킹은 **정수를 비트 단위로 다뤄, 메모리를 절약하고 연산 속도를 최적화**하는 기법이다.

### 📌 주요 개념
- 하나의 정수를 **비트 집합(Bitset)처럼 사용**할 수 있음.
- `1 << n`을 사용하여 **n 번째 비트를 조작**할 수 있음.

### 📌 기본 연산
| 연산 | 설명 | 예제 (`visited = 0b0000`) |
|------|------|------------------------|
| `visited | (1 << n)` | n번 비트 켜기(추가) | `visited | (1 << 2) → 0b0100` |
| `visited & ~(1 << n)` | n번 비트 끄기(제거) | `visited & ~(1 << 2) → 0b0000` |
| `(visited & (1 << n)) != 0` | n번 비트 확인 | `visited & (1 << 2) → 0이면 미방문` |

### 📌 예제: 비트마스킹을 활용한 순열
```java
import java.io.*;
import java.util.*;

public class BitmaskingPermutation {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        generatePermutations(0, 0, new int[N]);
        System.out.print(sb);
    }

    static void generatePermutations(int depth, int visited, int[] output) {
        if (depth == N) {
            for (int num : output) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0) { // i번째 숫자가 아직 선택되지 않았다면
                output[depth] = arr[i];
                generatePermutations(depth + 1, visited | (1 << i), output); // i 사용 표시 후 재귀
            }
        }
    }
}
```

## 3. DFS vs 백트래킹
| 구분 | DFS (깊이 우선 탐색) | 백트래킹 |
|------|----------------|----------|
| 탐색 방식 | 모든 경우를 탐색 | 유망한 경우만 탐색 |
| 최적화 여부 | ❌ (완전 탐색) | ✅ (가지치기) |
| 적용 예시 | 그래프 탐색 | N-Queen, 순열, 조합 |

## 4. 비트마스킹을 활용한 방문 상태 관리
비트마스킹을 활용하면 **boolean 배열을 사용하지 않고** 방문 상태를 한 개의 정수로 표현할 수 있음.

### 📌 기본 연산
```java
int visited = 0; // 초기 상태: 0b0000 (모두 미방문)

// 2번 노드 방문 처리
visited |= (1 << 2); // 0b0000 -> 0b0100

// 2번 노드 방문 여부 확인
if ((visited & (1 << 2)) != 0) {
    System.out.println("2번 노드 방문됨");
}

// 2번 노드 방문 해제
visited &= ~(1 << 2); // 0b0100 -> 0b0000
```

## 📌 정리
✅ **백트래킹**
- **DFS 기반**으로 탐색하되, **불필요한 경우(유망하지 않은 경우)는 제외**하여 탐색 속도를 높임.
- **N-Queen, 순열 & 조합, Sudoku 등의 문제에서 활용됨**.

✅ **비트마스킹**
- **정수를 비트 단위로 다뤄 메모리를 절약**하고 연산을 빠르게 수행함.
- **방문 여부 체크, 부분집합 문제, 순열/조합 문제 최적화에 활용**됨.

백트래킹 + 비트마스킹을 조합하면 **최적화된 백트래킹 탐색**이 가능함! 🚀
