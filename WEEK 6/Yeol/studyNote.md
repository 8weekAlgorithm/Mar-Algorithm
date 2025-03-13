# 집합(Set), 해시(Hash), 이진 검색 트리(BST)

## 1. 집합(Set)

### ✅ 개념
- **중복을 허용하지 않는 자료구조**
- **특정 원소가 존재하는지 빠르게 확인 가능**
- Java에서 대표적인 구현체:
  - `HashSet`: **해시 기반**, 빠른 삽입/삭제/탐색 (`O(1)`)
  - `TreeSet`: **이진 검색 트리 기반 (Red-Black Tree)**, 정렬된 상태 유지 (`O(log N)`)
  - `LinkedHashSet`: **입력 순서 유지**, 내부적으로 `HashSet` + `LinkedList`

### ✅ HashSet 예제
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println("저장된 원소: " + set);
        System.out.println("5 포함 여부: " + set.contains(5));
    }
}
```

---

## 2. 해시(Hash)

### ✅ 개념
- **데이터를 빠르게 저장하고 검색하는 기술**
- Key-Value 형태로 저장하는 자료구조 = **HashMap**
- Key를 기준으로 탐색하면 **평균 `O(1)`** 에 조회 가능

### ✅ HashMap 예제
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        map.put("사과", 3);
        map.put("바나나", 5);
        map.put("오렌지", 2);

        System.out.println("바나나 개수: " + map.get("바나나"));
        System.out.println("키 존재 여부: " + map.containsKey("사과"));
    }
}
```

---

## 3. 이진 검색 트리 (BST)

### ✅ 개념
- **왼쪽 자식 < 부모 < 오른쪽 자식** 규칙을 따름
- `O(log N)` 시간 복잡도를 가짐 (균형 유지 시)
- **TreeSet** / **TreeMap**은 Red-Black Tree로 구현됨

### ✅ BST 예제
```java
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = tree.insert(tree.root, 10);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 25);

        System.out.print("BST 중위 순회: ");
        tree.inorder(tree.root);
    }
}
```

---

## 4. 레드-블랙 트리 (Red-Black Tree)

### ✅ 개념
- BST는 한쪽으로 치우칠 경우 `O(N)`의 성능 저하 발생 가능
- RBT는 **균형을 유지하는 자체적인 규칙**을 가진 BST으로, 탐색, 삽입, 삭제를 `O(log N)` 유지
- **TreeSet과 TreeMap이 RBT로 구현됨**

---

## 5. LinkedHashSet & LinkedHashMap

### ✅ 개념
- **입력 순서 유지**
- `HashSet` + `LinkedList` 조합

### ✅ LinkedHashSet 예제
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(2);

        System.out.println("입력 순서 유지: " + set);
    }
}
```

---

## 6. PriorityQueue (우선순위 큐)

### ✅ 개념
- **최솟값/최댓값을 빠르게 찾을 때 사용 (`O(log N)`)**
- 내부적으로 **Heap (이진 트리) 사용**
- 기본적으로 **최소 힙 (Min-Heap)**

### ✅ PriorityQueue 예제
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(15);

        while (!pq.isEmpty()) {
            System.out.println("최솟값 꺼내기: " + pq.poll());
        }
    }
}
```

---

## 📌 정리

| 자료구조 | 내부 구현 | 주요 특징 |
|---------|---------|---------|
| `HashSet` | 해시 | 중복X, 순서X, `O(1)` |
| `TreeSet` | RBT | 중복X, 정렬O, `O(log N)` |
| `LinkedHashSet` | 해시 + 연결 리스트 | 중복X, 순서O |
| `HashMap` | 해시 | Key-Value 저장, `O(1)` |
| `TreeMap` | RBT | 정렬된 Key-Value, `O(log N)` |
| `LinkedHashMap` | 해시 + 연결 리스트 | 순서 유지 |
| `PriorityQueue` | Heap | 최솟값/최댓값 빠르게 찾기 |

---

이해 안 되는 부분 있으면 질문해! 😃
