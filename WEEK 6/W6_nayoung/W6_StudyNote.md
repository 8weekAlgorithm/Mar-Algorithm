# HashTable, HashMap, HashSet, TreeMap, TreeSet, Red-Black Tree

<aside>
💡

**Hash**

임의의 크기를 가진 데이터(Key)를 고정된 크기의 데이터(Value)로 변화시켜 저장하는 것.

- 해싱(Hashing) : 키에 대한 해시값을 구하는 과정
- 해시함수(Hash Function) : 키에 대한 해시값을 만드는 함수(알고리즘), 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수.
    - 대표적인 해시함수로는 MD5, SHA 등이 있다.
    - 해시 함수에 의해 얻어지는 값은 해시 값, 해시 코드, 해시 체크섬 또는 간단하게 해시라고 한다.
- 해시를 통한 데이터 저장시에는 검색과 저장이 아주 빠르게 진행
    - 데이터 검색 시 사용할 key와 실제 데이터의 값(value)이 한 쌍으로 존재하고, ke값이 인덱스로 변환되기 때문에 검색과 저장의 평균적인 시간 복잡도가 O(1)에 수렴
</aside>

### 1. HashTable

- 해시함수를 사용하여 키를 해시값으로 매핑하고, 이 해시값을 주소 또는 색인(index) 삼아 데이터(value)를 key와 함께 저장하는 자료구조
- 데이터가 저장되는 곳을 `버킷(bucket)`, `슬롯(slot)` 이라고 한다.
- hash table의 장단점
    - 장점
        - 데이터 저장/읽기 속도가 빠르다 ⇒ 검색 속도가 빠르다.
        - 해쉬는 키에 대한 데이터가 있는지(중복) 확인이 쉽다.
        - 충돌이 없다면 해시테이블은 시간복잡도가 O(1)로 짧다!
    - 단점
        - 일반적으로 저장공간이 좀 더 많이 필요하다.
        - 해시 충돌이 발생한다면 O(N)까지 시간복잡도가 증가할 수 있다.
- 주요 용도
    - 검색이 많이 필요한 경우
    - 저장/삭제/읽기가 빈번한 경우
    - 캐쉬 구현시 (중복 확인 쉽기 때문)

> **☝️ Hashtable VS HashMap (Java)**
> 
> 
> 자바에서 해시 테이블을 구현한 클래스 중 가장 오래된 클래스는 `Hashtable` 클래스이다. `Hashtable`은 컬렉션 프레임워크가 만들어지기 이전부터 존재하던 것이기 때문에 컬렉션 프레임워크의 명명법을 따르지 않는다. 자바에서 해시 테이블을 두번째로 구현한 클래스는 `HashMap`으로, `Hashtable`과 사용 방법이 거의 비슷하다. 둘 사이의 가장 큰 차이점은 동기화(synchronized) 지원 여부이다. `HashMap`은 동기화를 지원하지 않는다. 즉, thread-safe하지 않아 단일 스레드 환경에서 사용하기에 적합한 자료구조이다. 반면 `Hashtable`은 동기화 처리를 하기 때문에 멀티스레드 환경에서도 사용하기 좋은 자료구조이지만, 이 동기화로 인한 추가적인 처리 문제로 `HashMap`에 비해 성능상 느리다.
> 

### 2. HashMap

- `Map Interface`의 구현체로, Hash Table과 유사한 자료구조로 데이터를 저장한다.
- key-value 형태로 데이터를 저장하며, 중복 key는 허용하지 않지만 중복 value는 허용한다.
- 데이터를 삽입 시 key-value 형태의 한 쌍의 데이터를 저장하기 때문에 삽입 연산동안 단 하나의 객체가 생성된다.
- 단 하나의 null값을 key값으로 가질 수 있고, 중복이 허용된 value의 경우 여러 null값을 가질 수 있다.
- `HashSet`보다 속도가 빠르다.
- `HashMap`의 경우 데이터가 입력되는 순서는 보장하지 않는데, 이를 확장한 `LinkedHashMap`은 자료가 입력된 순서를 기억한다.

### 3. HashSet

- `Set Interface`의 구현체로, 내부적으로 `HashMap`을 사용해 데이터를 저장하기 때문에 Hash Table과 유사한 자료구조로 데이터를 저장한다고 할 수 있다.
- 객체 그 자체를 저장하며, 이때 key값으로는 삽입되는 객체 자체를, value값으로는 내부 구현 코드에서 필드로 선언한 객체를 사용한다.
- 데이터를 삽입 시 객체 자체를 저장하고, 내부적으로 `HashMap`을 사용하기 때문에 삽입되는 객체(key 값)와 dummy 객체(value 값), 총 2개의 객체가 삽입 연산 동안 생성된다.
- 객체 자체를 저장하는 형태이기 때문에 데이터 중복을 허용하지 않으며, 단 하나의 null 값을 가질 수 있다.
- 오직 객체만 저장 가능하므로 `HashMap`보다 느리다.

### 4. TreeMap, TreeSet

- 각각 Map과 Set 인터페이스를 구현한 클래스로써 각 인터페이스의 성질을 그대로 가지고 있다. 하지만 `HashMap`, `HashSet`과는 달리 이진 탐색 트리(Binary Search Tree) 구조로 이루어져 있어서 자동정렬을 해준다는 차이점이 있다.
    - `TreeMap`은 키를 기준으로 오름차순 자동정렬을, `TreeSet`은 객체 자체를 기준으로 오름차순 자동정렬을 해준다.
- 이진 탐색 트리는 추가와 삭제에는 시간이 조금 더 걸리지만 정렬, 검색에 높은 성능을 보이는 자료구조로, `TreeMap`과 `TreeSet`은 각각 Map과 Set 컬렉션의 검색 기능을 강화시킨 클래스이다.
- `HashSet`의 `add`, `remove`, `contains` 메소드는 일정한 시간복잡도인 O(1)을 갖는 반면 TreeSet은 각각의 요소들을 자동으로 정렬시키며 `add`, `remove`, `contains` 메소드의 시간복잡도가 O(logN)을 갖는다.

### 5. Red-Black Tree (레드-블랙 트리)

- TreeMap, TreeSet은 정확히 말하면 레드-블랙 트리를 베이스로 한 구현을 사용한다.
- **Red-Black Tree**는 **균형 이진 탐색 트리(Self-balancing Binary Search Tree)**의 한 종류로, 삽입 및 삭제 연산이 발생할 때도 **트리의 균형을 유지**하여 **탐색, 삽입, 삭제** 등의 연산을 **O(log n)**의 시간 복잡도로 보장한다.

---

참고자료

- Hash란? : https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98
- Hash란? : https://velog.io/@colorful8315/Hash%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80
- Hash Table : https://velog.io/@mooh2jj/Hash%EC%9D%98-%EA%B0%9C%EB%85%90-%EB%B0%8F-%EC%84%A4%EB%AA%85
- HashMap VS HashTable : https://velog.io/@kwj2435/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Hash-HashMap-HashTable
- HashMap VS HashSet : https://siahn95.tistory.com/96#google_vignette
- Map, HashMap, TreeMap 끝판왕 : https://velog.io/@kimunche/HashMap-TreeMap-%EC%B0%A8%EC%9D%B4%EB%A5%BC-%EC%95%8C%EC%95%84boza
- HashSet VS TreeSet : https://github.com/Today-I-Learn/backend-study/blob/develop/JAVA/Collection/%5B%2345%5D%20HashSet%EA%B3%BC%20TreeSet%EC%9D%98%20%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%9D%80%20%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80%EC%9A%94.md
- Red-Black Tree : https://velog.io/@dankj1991/Tree-Red-Black-Tree-Part1