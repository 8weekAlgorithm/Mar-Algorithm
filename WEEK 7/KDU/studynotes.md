## **백트래킹(Backtracking)**

### 1. 개념

백트래킹은 가능한 모든 경우를 탐색하되, 유망하지 않은 경우를 가지치기하여 탐색 시간을 줄이는 방식이다.
즉, **완전탐색(Brute Force)보다 효율적**이며, **DFS(깊이 우선 탐색) 기법을 기반으로 구현**된다.

### 2. 특징

- **가지치기 (Pruning)**: 탐색 도중 유망하지 않은 경우를 제외하여 탐색 시간을 줄임
- **재귀 (Recursion) 활용**: 보통 재귀 함수로 구현됨
- **DFS의 최적화된 형태**: 모든 경우의 수를 탐색하되, 필요 없는 경우는 제외

### **3. 예제 코드 (N-Queen 문제)**

```java
public class NQueen {
    static int N;
    static int[] board;
    static int result = 0;

    public static void main(String[] args) {
        N = 4; // N-Queen 문제에서 4x4 체스판 예제
        board = new int[N];
        solve(0);
        System.out.println("가능한 경우의 수: " + result);
    }

    static void solve(int row) {
        if (row == N) { // 모든 행에 배치 완료
            result++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) {
                board[row] = col;
                solve(row + 1);
            }
        }
    }

    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}
```

## **비트마스킹 (Bitmasking)**

### 1. 개념

비트마스킹은 **정수를 이진수(비트)로 표현하여 집합 연산을 수행하는 기법**이다.
이를 통해 **메모리를 절약하면서 연산 속도를 향상**시킬 수 있다.

### 2. 특징

- **공간 효율성**: `boolean[]` 배열을 사용할 필요 없이, 정수 하나(`int` 또는 `long`)로 여러 개의 상태를 저장 가능
- **연산 속도 향상**: 비트 연산(`&`, `|`, `^`, `<<`, `>>`)을 활용해 빠르게 상태 변경
- **특정 원소 포함 여부, 추가, 삭제 등을 O(1) 연산으로 수행 가능**

### **3. 예제 코드 (비트마스킹을 활용한 방문 상태 관리)**

```java
public class BitmaskingExample {
    public static void main(String[] args) {
        int visited = 0; // 초기 상태: 0000
        
        // 2번 노드 방문
        visited |= (1 << 2); // 0100
        System.out.println(Integer.toBinaryString(visited));
        
        // 2번 노드 방문 여부 확인
        if ((visited & (1 << 2)) != 0) {
            System.out.println("2번 노드 방문함");
        }
        
        // 2번 노드 방문 해제
        visited &= ~(1 << 2); // 0000
        System.out.println(Integer.toBinaryString(visited));
    }
}
```

### **4. DFS에서 비트마스킹 활용 (부분 수열 문제 예제)**

```java
public class SubsetBitmask {
    static int[] arr = {1, 2, 3};
    static int N = arr.length;
    
    public static void main(String[] args) {
        for (int bitmask = 0; bitmask < (1 << N); bitmask++) {
            System.out.print("{ ");
            for (int i = 0; i < N; i++) {
                if ((bitmask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
```

### **5. DFS와 비트마스킹을 함께 활용 (순열 예제)**

```java
public class PermutationBitmask {
    static int N = 3;
    static int[] arr = {1, 2, 3};

    public static void main(String[] args) {
        dfs(0, 0, "");
    }

    static void dfs(int depth, int visited, String result) {
        if (depth == N) {
            System.out.println(result);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0) { // 방문 안 했을 경우
                dfs(depth + 1, visited | (1 << i), result + arr[i] + " ");
            }
        }
    }
}
```

# DFS vs 백트래킹

| 구분 | DFS | 백트래킹 |
| --- | --- | --- |
| 탐색 방식 | 깊이 우선 탐색 | DFS 기반, 가지치기 추가 |
| 탐색 범위 | 모든 경우 탐색 | 불필요한 경우 제외 |
| 최적화 | 없음 | 가지치기로 탐색 속도 개선 |
| 예제 | 그래프 탐색 | N-Queen, 순열 등 |

---