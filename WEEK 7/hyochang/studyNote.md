## 백트래킹 비트마스킹


### 1. **백트래킹 (Backtracking) 예시: 순열 구하기**

자바에서 백트래킹을 사용하여 순열을 구하는 예시입니다. `visited` 배열을 사용하여 방문 여부를 처리하고, 재귀적으로 순열을 생성한 후 백트래킹을 통해 되돌리며 탐색합니다.

```java
import java.util.*;

public class BacktrackingExample {
    static List<List<Integer>> result = new ArrayList<>();
    
    public static void backtrack(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));  // 순열이 완성되면 결과에 추가
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;  // 이미 방문한 숫자는 건너뛰기
            visited[i] = true;  // 방문 처리
            path.add(nums[i]);  // 해당 숫자 추가
            backtrack(nums, path, visited);  // 재귀 호출
            path.remove(path.size() - 1);  // 백트래킹 (되돌리기)
            visited[i] = false;  // 방문 처리 되돌리기
        }
    }
    
}
```
---

### 2. **비트마스킹 (Bitmasking) 예시: 부분 집합 구하기**

```java
import java.util.*;

public class BitmaskingExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        
        // 0부터 (2^n - 1)까지의 모든 비트마스크를 순회
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            
            // 비트마스크에서 각 비트의 값을 확인하여 해당 원소를 선택
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {  // i번째 비트가 1이면 선택
                    subset.add(arr[i]);
                }
            }
            
            // 부분 집합 출력
            System.out.println(subset);
        }
    }
}
```

위 코드는 `arr` 배열에서 부분 집합을 구하는 예시입니다. `mask`는 2진수로 각 원소의 선택 여부를 나타내며, `(1 << i)`를 통해 `i`번째 비트가 1인지 확인합니다. `mask & (1 << i)`가 1이면 `i`번째 원소를 선택한 것입니다.

---

### **비트마스킹과 백트래킹의 차이점**

- **백트래킹**은 재귀를 통해 탐색하고, 조건을 만족하지 않으면 가지치기하여 더 이상 탐색하지 않도록 하는 방식입니다. 주로 순열, 조합, 부분 집합을 구할 때 사용됩니다.
- **비트마스킹**은 2진수를 활용하여 상태나 집합을 효율적으로 표현하고 관리하는 기법입니다. 집합의 부분 집합을 구하거나 상태를 빠르게 추적할 때 유용합니다.

