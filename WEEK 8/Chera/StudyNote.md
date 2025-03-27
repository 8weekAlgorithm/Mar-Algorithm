# 1. Greedy Algorithm (탐욕 알고리즘)

## ✅ 정의
- 매 순간 가장 최적인 선택을 하는 알고리즘
- "지금 이 순간"만 고려 → 전체 최적해가 되도록

## ✅ 조건
1. **Greedy Choice Property**: 현재의 선택이 이후에 영향 X
2. **Optimal Substructure**: 부분 문제 최적해 → 전체 문제 최적해 구성 가능

## ✅ 특징
- 미래 상황 고려 X
- 직관적이고 구현 간단
- 정렬과 함께 자주 사용됨

## ✅ 자주 등장하는 문제 유형
- 동전 거스름돈
- 회의실 배정
- 활동 선택 문제
- 배낭 문제 (단, 0-1 Knapsack은 DP)

## ✅ 자바 예시 (동전 거스름돈)
```java
int[] coins = {500, 100, 50, 10};
int n = 1260;
int count = 0;

for (int coin : coins) {
    count += n / coin;
    n %= coin;
}
System.out.println(count);
```

# Dynamic Programming (DP)

## ✅ 정의
- 큰 문제 → 작은 문제로 나눠서 푸는 방법  
- 중복되는 부분 문제의 결과를 저장해서 재사용

## ✅ 필요 조건
1. **Overlapping Subproblems (중복 부분 문제)**  
   → 같은 계산 여러 번 반복됨  
2. **Optimal Substructure (최적 부분 구조)**  
   → 전체 문제의 최적해 = 부분 문제 최적해 조합

## ✅ 핵심 전략
- **Top-down (재귀 + 메모이제이션)**  
  → 필요한 순간 계산 + 캐싱  
- **Bottom-up (반복문 + 테이블)**  
  → 작은 문제부터 차례로 계산  

## ✅ 장점
- 모든 경우의 수 고려 → 항상 최적해 보장
- 중복 계산 제거 → 시간 절약

## ✅ 단점
- 메모리 많이 씀
- 상태 정의와 점화식 찾기 어려움

## ✅ 자주 나오는 문제
- 피보나치 수
- 최장 공통 부분 수열 (LCS)
- 최소 동전 개수
- 0-1 배낭 문제
- 계단 오르기, 삼각형 최단 경로

## ✅ 자바 예제

### 📌 피보나치 수 (Top-down)
```java
int[] dp = new int[100];

int fib(int n) {
    if (n <= 1) return n;
    if (dp[n] != 0) return dp[n];
    return dp[n] = fib(n - 1) + fib(n - 2);
}
```
