# 그리디(Greedy) vs 동적 프로그래밍(Dynamic Programming)

## 1. 그리디 알고리즘 (Greedy Algorithm)

### ✅ 개념
- 매 단계에서 **현재 가장 좋아 보이는 선택(최적 선택)** 을 하는 알고리즘.
- **미래의 결과를 고려하지 않고**, 현재 단계에서의 최선이 전체적으로도 최선일 것이라고 믿고 선택함.

### ✅ 사용 조건
- **탐욕적 선택 속성 (Greedy Choice Property)**: 현재의 선택이 이후의 선택에 영향을 주지 않음.
- **최적 부분 구조 (Optimal Substructure)**: 문제의 최적해가 부분 문제의 최적해로부터 구성됨.

### ✅ 자주 나오는 예시
- 거스름돈 문제
- 회의실 배정 문제
- 활동 선택 문제
- 최소 신장 트리 (MST): Prim, Kruskal
- Dijkstra 알고리즘 (우선순위 큐 활용)

### ✅ 예제 코드 (거스름돈 문제)
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] coins = {500, 100, 50, 10}; // 동전 단위
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 거슬러 줘야 할 금액
        int count = 0;

        for (int coin : coins) {
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);
    }
}
```

---

## 2. 동적 프로그래밍 (Dynamic Programming)

### ✅ 개념
- 큰 문제를 **작은 문제로 나누고**, 그 결과를 **메모이제이션** 해서 재사용하는 방식.
- **중복되는 부분 문제**가 있을 때 매우 효과적임.

### ✅ 사용 조건
- **중복 부분 문제 (Overlapping Subproblems)**: 동일한 작은 문제들이 반복됨.
- **최적 부분 구조 (Optimal Substructure)**: 부분 문제의 최적 결과로 전체 문제의 최적 결과를 만들 수 있음.

### ✅ 자주 나오는 예시
- 피보나치 수열
- 동전 교환 문제
- 배낭 문제 (Knapsack)
- 최장 공통 부분 수열 (LCS)
- LIS(최장 증가 부분 수열)

### ✅ 예제 코드 (피보나치 수열 - Bottom-Up)
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 50;
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
```

---

## 3. 그리디 vs DP 비교

| 항목 | 그리디 | DP |
|------|--------|----|
| 접근 방식 | 매 단계에서 최선 선택 | 모든 경우 고려 후 메모이제이션 |
| 조건 | 탐욕적 선택 속성 + 최적 부분 구조 | 중복 부분 문제 + 최적 부분 구조 |
| 속도 | 빠름 (보통 O(N)) | 느릴 수 있음 (보통 O(N^2), O(NK) 등) |
| 정답 보장 | 항상은 아님 | 조건 만족하면 정답 보장 |
| 예시 | 거스름돈, 회의실 배정, MST | 피보나치, LCS, 배낭 문제 |

---

## 4. 언제 그리디를 쓰고 언제 DP를 써야 할까?

- **그리디**: 미래를 고려하지 않아도 항상 현재의 최선이 전체의 최선인 경우.
- **DP**: 경우의 수가 많고, 같은 계산을 반복하게 되는 경우.

---

## 📌 팁
- 문제를 먼저 **작은 입력값**으로 풀어보며 그리디로 정답이 항상 나오는지 확인.
- 그리디가 안 될 경우 DP로 풀 수 있는지 구조를 파악해보기.
