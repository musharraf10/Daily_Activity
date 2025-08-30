//  🧠 Java Collections Framework (JCF)

// The Java Collections Framework is a set of interfaces + classes that help us store, manipulate, and retrieve groups of objects efficiently.
// It mainly contains List, Set, Queue, and Map types.

// ---

//  1. Collection Hierarchy

// At the top:

//  Iterable (interface) → root for iteration (`for-each`, `iterator()`).
//  Collection (interface) → base for most collections (`List`, `Set`, `Queue`).
//  Map (interface) → separate hierarchy (not part of `Collection`).

// ```
// Iterable
//    └── Collection
//           ├── List
//           ├── Set
//           └── Queue
//    └── Map (separate branch)
// ```

// ---

//  2. List (Ordered, duplicates allowed)

//  Maintains insertion order.
//  Access elements by index.

//  Common Implementations:

// 1. ArrayList

//     Backed by dynamic array.
//     ✅ Fast random access (`O(1)`).
//     ❌ Slow insertion/deletion in middle (`O(n)`).
//     ✅ Good for read-heavy operations.

// 2. LinkedList

//     Doubly linked list.
//     ✅ Fast insertion/deletion (`O(1)`) if you already have the node.
//     ❌ Slow random access (`O(n)`).
//     ✅ Better for frequent add/remove.

// 3. Vector (Legacy)

//     Like `ArrayList` but thread-safe (synchronized).
//     Slower due to synchronization overhead.
//     Rarely used today.

// 📌 Example:

// ```java
// List<String> list = new ArrayList<>();
// list.add("A");
// list.add("B");
// list.add("A"); // duplicates allowed
// System.out.println(list); // [A, B, A]
// ```

// ---

//  3. Set (Unique elements, no duplicates)

//  Implements mathematical set.
//  No indexing (unordered by default).

//  Common Implementations:

// 1. HashSet

//     Uses HashMap internally.
//     ✅ Fast `add`, `remove`, `contains` → `O(1)` average.
//     ❌ No ordering guarantee.

// 2. LinkedHashSet

//     Like `HashSet`, but maintains insertion order.
//     Slightly slower than `HashSet`.

// 3. TreeSet

//     Sorted set, based on Red-Black Tree.
//     ✅ Keeps elements in sorted order.
//     ✅ Supports range operations (`headSet`, `tailSet`).
//     ❌ Slower than `HashSet` → `O(log n)`.

// 📌 Example:

// ```java
// Set<Integer> set = new HashSet<>();
// set.add(10);
// set.add(5);
// set.add(10); // ignored
// System.out.println(set); // [10, 5] (order not guaranteed)
// ```

// ---

//  4. Queue (FIFO structure)

//  Used when order of processing matters.
//  Special subtype: Deque (double-ended queue).

//  Common Implementations:

// 1. PriorityQueue

//     Elements ordered by natural order or custom comparator.
//     Min-heap by default.
//     `O(log n)` for insertion/removal.

// 2. ArrayDeque

//     Resizable array-based deque.
//     Faster than `Stack` and `LinkedList`.

// 3. LinkedList

//     Can also act as a Queue/Deque.

// 📌 Example:

// ```java
// Queue<Integer> q = new LinkedList<>();
// q.add(1);
// q.add(2);
// q.add(3);
// System.out.println(q.poll()); // 1 (FIFO)
// ```

// ---

//  5. Map (Key-Value pairs, unique keys)

//  Keys must be unique, values can be duplicate.

//  Common Implementations:

// 1. HashMap

//     Hash table + linked list/balanced tree (Java 8+).
//     ✅ Fast `get`, `put` → `O(1)` average.
//     ❌ No order guarantee.

// 2. LinkedHashMap

//     Maintains insertion order (or access order with access-order flag).
//     Slightly slower than `HashMap`.

// 3. TreeMap

//     Sorted map using Red-Black Tree.
//     ✅ Ordered by keys.
//     `O(log n)` operations.

// 4. Hashtable (Legacy)

//     Like `HashMap` but synchronized.
//     Slower, rarely used.

// 📌 Example:

// ```java
// Map<String, Integer> map = new HashMap<>();
// map.put("A", 1);
// map.put("B", 2);
// map.put("A", 3); // overrides
// System.out.println(map); // {A=3, B=2}
// ```

// ---

//  6. Operations & Utilities

// Common operations:

//  add / put
//  remove
//  contains / containsKey
//  size, isEmpty
//  iteration (for-each, Iterator, Streams)

//  `Collections` Utility Class

//  `Collections.sort(list)`
//  `Collections.reverse(list)`
//  `Collections.max(list)`
//  `Collections.unmodifiableList(list)`

//  `Arrays` Utility Class

//  Works with arrays (not collections).
//  `Arrays.sort(arr)`
//  `Arrays.asList(arr)`

// ---

//  7. Time Complexity Cheat Sheet

// | Collection    | Access | Insert   | Delete   | Search   |
// | ------------- | ------ | -------- | -------- | -------- |
// | ArrayList     | O(1)   | O(n)     | O(n)     | O(n)     |
// | LinkedList    | O(n)   | O(1)     | O(1)     | O(n)     |
// | HashSet       | -      | O(1)     | O(1)     | O(1)     |
// | TreeSet       | -      | O(log n) | O(log n) | O(log n) |
// | HashMap (key) | -      | O(1)     | O(1)     | O(1)     |
// | TreeMap (key) | -      | O(log n) | O(log n) | O(log n) |

// ---

// ✅ Best Practices

//  Use `ArrayList` when random access needed.
//  Use `LinkedList` when frequent add/remove.
//  Use `HashSet` for unique collection, `TreeSet` if sorting needed.
//  Use `HashMap` for key-value, `LinkedHashMap` if order matters.
//  Use `ConcurrentHashMap` in multithreading.

// ---

// ⚡ That’s the complete theory of Java Collections Framework.

// Do you want me to also create a visual diagram (flowchart style) for the hierarchy (List, Set, Map) so it’s easy to revise before interviews?


//  🧠 Java Collections Framework (Interfaces, Classes & Methods)

//  1. Interfaces

// These are contracts that define operations but don’t implement them. Classes implement them.

//  Main Interfaces:

//  `Iterable<T>`
//  `Collection<T>`
//  `List<T>`
//  `Set<T>`
//  `Queue<T>`
//  `Deque<T>`
//  `Map<K,V>`
//  `SortedSet<T>`, `NavigableSet<T>`
//  `SortedMap<K,V>`, `NavigableMap<K,V>`

// ---

//  2. Classes

// These are concrete implementations of interfaces.

//  List → `ArrayList`, `LinkedList`, `Vector`, `Stack`
//  Set → `HashSet`, `LinkedHashSet`, `TreeSet`
//  Queue/Deque → `PriorityQueue`, `ArrayDeque`, `LinkedList`
//  Map → `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`, `ConcurrentHashMap`

// ---

//  3. Methods in Each Interface

//  (A) `Iterable<T>`

//  `iterator()`
//  `forEach(Consumer<? super T> action)`
//  `spliterator()`

// ---

//  (B) `Collection<T>` (extends `Iterable`)

//  `boolean add(E e)`
//  `boolean addAll(Collection<? extends E> c)`
//  `void clear()`
//  `boolean contains(Object o)`
//  `boolean containsAll(Collection<?> c)`
//  `boolean isEmpty()`
//  `Iterator<E> iterator()`
//  `boolean remove(Object o)`
//  `boolean removeAll(Collection<?> c)`
//  `boolean retainAll(Collection<?> c)`
//  `int size()`
//  `Object[] toArray()`
//  `<T> T[] toArray(T[] a)`

// ---

//  (C) `List<T>` (extends `Collection`)

//  `E get(int index)`
//  `E set(int index, E element)`
//  `void add(int index, E element)`
//  `boolean addAll(int index, Collection<? extends E> c)`
//  `E remove(int index)`
//  `int indexOf(Object o)`
//  `int lastIndexOf(Object o)`
//  `ListIterator<E> listIterator()`
//  `ListIterator<E> listIterator(int index)`
//  `List<E> subList(int fromIndex, int toIndex)`

// Classes: `ArrayList`, `LinkedList`, `Vector`, `Stack`

// ---

//  (D) `Set<T>` (extends `Collection`)

//  Inherits all methods from `Collection`.
//  No duplicates allowed.
//  No extra methods in `Set` interface itself.

// Classes: `HashSet`, `LinkedHashSet`, `TreeSet`

// ---

//  (E) `SortedSet<T>` (extends `Set`)

//  `Comparator<? super E> comparator()`
//  `E first()`
//  `E last()`
//  `SortedSet<E> headSet(E toElement)`
//  `SortedSet<E> tailSet(E fromElement)`
//  `SortedSet<E> subSet(E fromElement, E toElement)`

// Class: `TreeSet`

// ---

//  (F) `NavigableSet<T>` (extends `SortedSet`)

//  `E ceiling(E e)`
//  `E floor(E e)`
//  `E higher(E e)`
//  `E lower(E e)`
//  `E pollFirst()`
//  `E pollLast()`
//  `NavigableSet<E> descendingSet()`
//  `Iterator<E> descendingIterator()`

// Class: `TreeSet`

// ---

//  (G) `Queue<T>` (extends `Collection`)

//  `boolean offer(E e)` → add element, return `false` if fails.
//  `E remove()` → remove head, throw exception if empty.
//  `E poll()` → remove head, return `null` if empty.
//  `E element()` → peek head, throw exception if empty.
//  `E peek()` → peek head, return `null` if empty.

// Classes: `LinkedList`, `PriorityQueue`

// ---

//  (H) `Deque<T>` (extends `Queue`)

//  `void addFirst(E e)`
//  `void addLast(E e)`
//  `boolean offerFirst(E e)`
//  `boolean offerLast(E e)`
//  `E removeFirst()`
//  `E removeLast()`
//  `E pollFirst()`
//  `E pollLast()`
//  `E getFirst()`
//  `E getLast()`
//  `E peekFirst()`
//  `E peekLast()`
//  `Iterator<E> descendingIterator()`

// Classes: `ArrayDeque`, `LinkedList`

// ---

//  (I) `Map<K,V>` (separate from Collection)

//  `V put(K key, V value)`
//  `void putAll(Map<? extends K, ? extends V> m)`
//  `V get(Object key)`
//  `V remove(Object key)`
//  `boolean containsKey(Object key)`
//  `boolean containsValue(Object value)`
//  `int size()`
//  `boolean isEmpty()`
//  `void clear()`
//  `Set<K> keySet()`
//  `Collection<V> values()`
//  `Set<Map.Entry<K,V>> entrySet()`

// Classes: `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`, `ConcurrentHashMap`

// ---

//  (J) `SortedMap<K,V>` (extends `Map`)

//  `Comparator<? super K> comparator()`
//  `K firstKey()`
//  `K lastKey()`
//  `SortedMap<K,V> headMap(K toKey)`
//  `SortedMap<K,V> tailMap(K fromKey)`
//  `SortedMap<K,V> subMap(K fromKey, K toKey)`

// Class: `TreeMap`

// ---

//  (K) `NavigableMap<K,V>` (extends `SortedMap`)

//  `Map.Entry<K,V> ceilingEntry(K key)`
//  `K ceilingKey(K key)`
//  `Map.Entry<K,V> floorEntry(K key)`
//  `K floorKey(K key)`
//  `Map.Entry<K,V> higherEntry(K key)`
//  `K higherKey(K key)`
//  `Map.Entry<K,V> lowerEntry(K key)`
//  `K lowerKey(K key)`
//  `Map.Entry<K,V> pollFirstEntry()`
//  `Map.Entry<K,V> pollLastEntry()`
//  `NavigableMap<K,V> descendingMap()`
//  `NavigableSet<K> descendingKeySet()`

// Class: `TreeMap`

// ---

//  4. Utility Classes

//  `Collections` class (static methods)

//  Sorting: `sort(list)`, `reverse(list)`, `shuffle(list)`
//  Searching: `binarySearch(list, key)`
//  Min/Max: `min(list)`, `max(list)`
//  Sync: `synchronizedList(list)`
//  Unmodifiable: `unmodifiableList(list)`

//  `Arrays` class

//  `Arrays.sort(arr)`
//  `Arrays.binarySearch(arr, key)`
//  `Arrays.asList(arr)`
//  `Arrays.copyOf(arr, newLength)`
//  `Arrays.equals(arr1, arr2)`

// ---

// ✅ So now you have:

// 1. Interfaces hierarchy
// 2. Implementing classes
// 3. All important methods grouped by interface

// Java Collections Framework — Quick Reference Table

// | **Interface**          | **Common Classes**                                                      | **Important Methods**                                                                                                                                                                                                |
// | ---------------------- | ----------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
// | **Iterable<T>**        | (All collections implement)                                             | `iterator()`, `forEach()`, `spliterator()`                                                                                                                                                                           |
// | **Collection<T>**      | (Parent of List, Set, Queue)                                            | `add(e)`, `addAll(c)`, `clear()`, `contains(o)`, `containsAll(c)`, `isEmpty()`, `remove(o)`, `removeAll(c)`, `retainAll(c)`, `size()`, `toArray()`                                                                   |
// | **List<T>**            | `ArrayList`, `LinkedList`, `Vector`, `Stack`                            | `get(i)`, `set(i,e)`, `add(i,e)`, `addAll(i,c)`, `remove(i)`, `indexOf(o)`, `lastIndexOf(o)`, `listIterator()`, `subList(from,to)`                                                                                   |
// | **Set<T>**             | `HashSet`, `LinkedHashSet`, `TreeSet`                                   | Inherits all `Collection` methods (no duplicates, no extra methods)                                                                                                                                                  |
// | **SortedSet<T>**       | `TreeSet`                                                               | `comparator()`, `first()`, `last()`, `headSet(e)`, `tailSet(e)`, `subSet(from,to)`                                                                                                                                   |
// | **NavigableSet<T>**    | `TreeSet`                                                               | `ceiling(e)`, `floor(e)`, `higher(e)`, `lower(e)`, `pollFirst()`, `pollLast()`, `descendingSet()`, `descendingIterator()`                                                                                            |
// | **Queue<T>**           | `LinkedList`, `PriorityQueue`                                           | `offer(e)`, `remove()`, `poll()`, `element()`, `peek()`                                                                                                                                                              |
// | **Deque<T>**           | `ArrayDeque`, `LinkedList`                                              | `addFirst(e)`, `addLast(e)`, `offerFirst(e)`, `offerLast(e)`, `removeFirst()`, `removeLast()`, `pollFirst()`, `pollLast()`, `getFirst()`, `getLast()`, `peekFirst()`, `peekLast()`, `descendingIterator()`           |
// | **Map\<K,V>**          | `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`, `ConcurrentHashMap` | `put(k,v)`, `putAll(m)`, `get(k)`, `remove(k)`, `containsKey(k)`, `containsValue(v)`, `size()`, `isEmpty()`, `clear()`, `keySet()`, `values()`, `entrySet()`                                                         |
// | **SortedMap\<K,V>**    | `TreeMap`                                                               | `comparator()`, `firstKey()`, `lastKey()`, `headMap(k)`, `tailMap(k)`, `subMap(from,to)`                                                                                                                             |
// | **NavigableMap\<K,V>** | `TreeMap`                                                               | `ceilingEntry(k)`, `floorEntry(k)`, `higherEntry(k)`, `lowerEntry(k)`, `ceilingKey(k)`, `floorKey(k)`, `higherKey(k)`, `lowerKey(k)`, `pollFirstEntry()`, `pollLastEntry()`, `descendingMap()`, `descendingKeySet()` |


// Utility Classes

// | **Class**     | **Important Methods**                                                                                                                                  |
// | ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
// | `Collections` | `sort(list)`, `reverse(list)`, `shuffle(list)`, `binarySearch(list,key)`, `min(list)`, `max(list)`, `synchronizedList(list)`, `unmodifiableList(list)` |
// | `Arrays`      | `sort(arr)`, `binarySearch(arr,key)`, `asList(arr)`, `copyOf(arr,len)`, `equals(arr1,arr2)`                                                            |


// Iterable
//    └── Collection
//          ├── List
//          │     ├── ArrayList
//          │     ├── LinkedList
//          │     ├── Vector
//          │           └── Stack
//          │
//          ├── Set
//          │     ├── HashSet
//          │     │     └── LinkedHashSet
//          │     └── SortedSet
//          │            └── NavigableSet
//          │                   └── TreeSet
//          │
//          └── Queue
//                ├── PriorityQueue
//                ├── Deque
//                │     ├── ArrayDeque
//                │     └── LinkedList
//                └── LinkedList (also works as Queue)
               
// Map (separate hierarchy, not child of Collection)
//    ├── HashMap
//    │     └── LinkedHashMap
//    ├── SortedMap
//    │     └── NavigableMap
//    │            └── TreeMap
//    └── Hashtable
//          └── Properties

// Memory Tricks

// List = Ordered + Duplicates
// Think: shopping list 🛒 (order matters, can add same item twice).

// Set = Unique
// Think: student roll numbers 🎓 (no duplicates).

// Queue = FIFO
// Think: people standing in a line at a ticket counter 🎟️.

// Map = Key-Value
// Think: dictionary 📖 (word → meaning).
