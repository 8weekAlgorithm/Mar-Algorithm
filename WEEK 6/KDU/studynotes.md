## **1. 집합(Set)**

**정의**

- 중복을 허용하지 않으며, 특정 원소가 존재하는지 빠르게 찾을 수 있는 자료구조.
- 수학적 개념인 집합과 동일한 특성을 가짐.
- 보통 **해시 테이블(Hash Table)** 또는 **이진 검색 트리(BST)** 를 기반으로 구현됨.

**시간 복잡도 (Java의 HashSet 기준)**

- 삽입(Insert): 평균 O(1) (최악의 경우 O(N))
- 삭제(Delete): 평균 O(1)
- 검색(Contains): 평균 O(1)

**자바에서 제공하는 클래스**

- `HashSet`: **해시 테이블을 기반으로 한 집합**, 빠른 검색 및 삽입 가능 (순서 보장 X)
- `TreeSet`: **이진 검색 트리(RBT) 기반**, 자동 정렬되며 O(logN) 연산 속도 보장
- `LinkedHashSet`: **입력 순서를 유지하는 HashSet**

### 예제 코드 (Java)

```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();  // 순서 유지 X, 빠름
        Set<Integer> treeSet = new TreeSet<>();  // 자동 정렬 O
        Set<Integer> linkedHashSet = new LinkedHashSet<>(); // 입력 순서 유지

        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);  // 중복된 값은 저장되지 않음

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}
```

### 출력 예시(중복 제거 & 순서 차이)

```markdown
HashSet: [1, 2, 3]  // 순서 랜덤
TreeSet: [1, 2, 3]  // 정렬된 순서
LinkedHashSet: [3, 1, 2]  // 입력 순서 유지
```

## **2. 해시(Hash)**

**정의**

- 데이터를 저장하고 검색하는 효율적인 기술.
- 특정 값을 **고유한 숫자(해시 값)** 로 변환하는 함수(`hash function`)을 사용.
- 주로 **해시 테이블(Hash Table)** 구조로 구현됨.
- **키(Key)-값(Value) 형태**로 데이터를 저장하는 `HashMap`이 대표적.

**시간 복잡도 (HashMap 기준)**

- 삽입/삭제: 평균 O(1)
- 검색: 평균 O(1)

**자바에서 제공하는 클래스**

- `HashMap`: 해시 테이블 기반의 **Key-Value 저장소**, 빠른 검색 및 삽입 가능
- `LinkedHashMap`: 해시 테이블 + **입력 순서 유지**
- `TreeMap`: 이진 검색 트리(RBT) 기반, **정렬된 순서 유지 (O(logN))**

**예제 코드 (Java)**

```java
import java.util.*;

public class HashExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 100);
        hashMap.put("Banana", 200);
        hashMap.put("Cherry", 300);

        System.out.println("HashMap: " + hashMap);
        System.out.println("Banana 가격: " + hashMap.get("Banana"));

        // 키 존재 여부 확인
        if (hashMap.containsKey("Apple")) {
            System.out.println("Apple이 존재합니다.");
        }
    }
}
```

**출력 예시**

```markdown
HashMap: {Apple=100, Banana=200, Cherry=300}  // 순서 랜덤
Banana 가격: 200
Apple이 존재합니다.
```

## **3. 이진 검색 트리 (Binary Search Tree, BST)**

**정의**

- 이진 트리의 한 종류로, **탐색, 삽입, 삭제가 평균 O(logN)으로 효율적**
- **왼쪽 서브트리**는 **부모보다 작은 값**, **오른쪽 서브트리**는 **부모보다 큰 값**을 가짐
- **단점:** 한쪽으로 치우친 경우(O(N)), 성능 저하 발생 가능 → **균형 트리(RBT) 사용**

**BST 연산 시간 복잡도**

- 삽입: O(logN) (평균) / O(N) (최악)
- 삭제: O(logN) (평균) / O(N) (최악)
- 검색: O(logN) (평균) / O(N) (최악)

**예제 코드 (Java)**

```java
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() { root = null; }

    void insert(int key) { root = insertRec(root, key); }

    Node insertRec(Node root, int key) {
        if (root == null) { return new Node(key); }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void inorder() { inorderRec(root); }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class BSTExample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("BST Inorder 순회 결과:");
        tree.inorder();
    }
}
```

**출력 예시 (Inorder Traversal)**

```markdown
BST Inorder 순회 결과:
20 30 40 50 60 70 80
```

## **4. 레드-블랙 트리 (Red-Black Tree)**

**정의**

- BST의 균형을 유지하는 **자기 균형 이진 검색 트리**
- **TreeSet, TreeMap은 내부적으로 레드-블랙 트리(RBT)로 구현**
- 탐색, 삽입, 삭제 모두 O(logN)을 보장

**레드-블랙 트리 특징**

- **노드는 빨강 또는 검정**
- **루트는 항상 검정**
- **레드 노드의 자식은 반드시 검정**
- **모든 리프에서 루트까지 검은 노드 수는 같음**

## **5. 함께 알아두면 좋은 자료구조**

| 자료구조 | 특징 |
| --- | --- |
| **LinkedHashSet** | 입력 순서를 유지하는 `HashSet` |
| **LinkedHashMap** | 입력 순서를 유지하는 `HashMap` |
| **PriorityQueue** | 최소/최대값을 빠르게 찾는 자료구조 (힙 기반) |

## **✅ TreeSet (이진 검색 트리 기반 Set)**

- 중복을 허용하지 않으며, **자동으로 정렬**됨.
- 내부적으로 **레드-블랙 트리(RBT)** 로 구현되어 있음.
- 기본적으로 **오름차순 정렬**되지만, `Comparator`를 사용하면 정렬 기준을 변경 가능.
- 삽입, 삭제, 탐색 연산이 **O(logN)** 의 성능을 가짐.

### **📌 TreeSet 사용 예제**

```java
import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(50);
        treeSet.add(30);
        treeSet.add(70);
        treeSet.add(20);
        treeSet.add(40);
        treeSet.add(60);
        treeSet.add(80);

        System.out.println("오름차순 정렬된 TreeSet: " + treeSet);

        System.out.println("최소값: " + treeSet.first());
        System.out.println("최대값: " + treeSet.last());

        System.out.println("50보다 작은 값들: " + treeSet.headSet(50));
        System.out.println("50 이상인 값들: " + treeSet.tailSet(50));
    }
}

```

**✅ 실행 결과**

```markdown
오름차순 정렬된 TreeSet: [20, 30, 40, 50, 60, 70, 80]
최소값: 20
최대값: 80
50보다 작은 값들: [20, 30, 40]
50 이상인 값들: [50, 60, 70, 80]
```

## **✅ TreeMap (이진 검색 트리 기반 Map)**

- **Key-Value 형태**로 데이터를 저장하면서 **자동으로 Key가 정렬됨**.
- **HashMap과의 차이점**
    - `HashMap`은 키의 순서를 보장하지 않음 (O(1) 검색)
    - `TreeMap`은 키가 **오름차순으로 정렬됨** (O(logN) 검색)
- 내부적으로 **레드-블랙 트리(RBT)** 로 구현됨.
- 특정 Key 범위를 검색하는 데 유용함.

### **📌 TreeMap 사용 예제**

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("banana", 200);
        treeMap.put("apple", 100);
        treeMap.put("cherry", 300);
        treeMap.put("date", 400);

        System.out.println("오름차순 정렬된 TreeMap: " + treeMap);

        System.out.println("첫 번째 키: " + treeMap.firstKey());
        System.out.println("마지막 키: " + treeMap.lastKey());

        System.out.println("banana 이하 Key들: " + treeMap.headMap("banana"));
        System.out.println("banana 이상 Key들: " + treeMap.tailMap("banana"));
    }
}

```

**✅ 실행 결과**

```markdown
오름차순 정렬된 TreeMap: {apple=100, banana=200, cherry=300, date=400}
첫 번째 키: apple
마지막 키: date
banana 이하 Key들: {apple=100}
banana 이상 Key들: {banana=200, cherry=300, date=400}
```

## **📌 정리: 언제 어떤 자료구조를 사용할까?**

| 자료구조 | 특징 | 시간 복잡도 |
| --- | --- | --- |
| **HashSet** | 중복 없는 Set, 순서 보장 X | O(1) (평균) |
| **LinkedHashSet** | 입력 순서 유지 | O(1) (평균) |
| **TreeSet** | **정렬된 상태 유지**, RBT 기반 | **O(logN)** |
| **HashMap** | Key-Value 저장, 순서 보장 X | O(1) (평균) |
| **LinkedHashMap** | Key-Value 저장, 입력 순서 유지 | O(1) (평균) |
| **TreeMap** | **Key 정렬 유지**, RBT 기반 | **O(logN)** |