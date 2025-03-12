# 1. 집합

- 중복을 허용하지 않고, 특정 원소가 있는지 빠르게 찾을 수 있는 구조

### HashSet
- 중복을 허용하지 않고, null을 허용하지 않음
- LinkedHashSet : 요소의 저장 순서 유지
```java
HashSet<Integer> set = new HashSet<>();
set.add();
set.remove(1);
set.clear();
```

### TreeSet
- 중복해서 저장할 수 없고 저장 순서가 유지 되지 않음.
- 이진 탐색 트리(BinarySearchTree) 구조로 이루어져있음. 
- HashSet보다 데이터의 추가와 삭제는 시간이 더 걸리지만 검색과 정렬에 유리함
```java
TreeSet<Integer> set = new TreeSet<>();
set.first(); // 최솟값
set.last(); // 최댓값
set.higher(value); // 입력값보다 큰 데이터 중 최솟값
set.lower(value); // 입력값보다 작은 데이터 중 최대값

Iterator iter = set.iterator(); //Iterator 사용
while(iter.hasNext()){ // 값이 있으면 true, 없으면 false
    System.out.println(iter.next());
}
```

**레드-블랙 트리(Red-Black Tree)**
- 이진 탐색트리 중에서도 성능을 향상시킨 것
- 부모노드보다 작은 값을 가지는 노드는 왼쪽 자식으로, 큰 값을 가지는 노드는 오른쪽 자식으로 배치하여 데이터의 추가나 삭제 시 트리가 한쪽으로 치우쳐지지 않도록 균형을 맞춤

# 2. Map

### HashMap
- 데이터를 저장할 때 키와 밸류가 짝을 이루어 저장됨
- 특정 데이터의 저장 위치를 해시함수를 통해 바로 알 수 있기 때문에 데이터의 추가, 삭제, 특히 검색이 빠르다는 장점이 있음
```java
HahsMap<String, String> map = new HashMap<>();
map.replace(key, value); // key와 일치하는 기존 데이터의 value를 변경
map.getOrDefault(key, defaultValue); // key와 맵핑된 value값을 반환하고 없으면 defaultValue값을 반환함
```

### TreeMap
- 이진 탐색 트리 형태로 데이터를 저장
- 값을 추가하면 정렬도 함께 실시
```java
TreeMap<String, String> map = new TreeMap<>();

map.firstKey(); // 가장 우선순위가 높은 Key 반환
map.lastKey(); // 가장 우선순위가 낮은 Key 반환

map.firstEntry(); // 가장 우선순위가 높은 Entry 반환
map.lastEntry(); // 가장 우선순위가 낮은 Entry 반환
map.ceilingKey(); // 지정된 Key와 일치하거나 큰 첫 번째 Key 값을 반환
map.floorKey(); // 지정된 Key와 일치하거나, 작은 첫 번째 Key 값을 반환
```