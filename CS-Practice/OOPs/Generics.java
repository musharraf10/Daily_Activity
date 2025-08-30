// # 🧠 2. Generics in Java (Type-Safe Collections and Methods)

// ### 🔹 Why Generics?

// Before Java 5, collections stored `Object`, so casting was needed and type-safety was weak.

// ✅ Without Generics:

// ```java
// List list = new ArrayList();
// list.add("Hello");
// list.add(123); // allowed
// String s = (String) list.get(0); // manual cast
// ```

// ❌ Risk: `ClassCastException` at runtime.

// ✅ With Generics:

// ```java
// List<String> list = new ArrayList<>();
// list.add("Hello");
// // list.add(123); // compile-time error
// String s = list.get(0); // no cast needed
// ```

// Generics → ** type safety**, **no casting**, **reusable code**.

// ---

// ### 🔹 Generic Classes

// ```java
// class Box<T> {
//     private T value;
//     public void set(T value) { this.value = value; }
//     public T get() { return value; }
// }

// Box<Integer> intBox = new Box<>();
// intBox.set(10);
// System.out.println(intBox.get());
// ```

// * `T` is a **type parameter**, replaced by actual type at usage.
// * Can use multiple: `<T, U>`.

// ---

// ### 🔹 Generic Methods

// ```java
// class Util {
//     public static <T> void printArray(T[] array) {
//         for (T item : array) {
//             System.out.print(item + " ");
//         }
//     }
// }

// Util.printArray(new String[]{"A","B","C"});
// Util.printArray(new Integer[]{1,2,3});
// ```

// * Declared `<T>` before return type.
// * Works with **any type**.

// ---

// ### 🔹 Bounded Type Parameters

// Restrict what type can be used.

// ```java
// class Calculator<T extends Number> {
//     private T num;
//     Calculator(T num) { this.num = num; }
//     double square() { return num.doubleValue() * num.doubleValue(); }
// }

// Calculator<Integer> c = new Calculator<>(5);
// System.out.println(c.square());
// ```

// ---

// ### 🔹 Wildcards (`?`)

// Used when exact type is unknown.

// * **Unbounded wildcard**: `List<?>` → any type.
// * **Upper bounded**: `List<? extends Number>` → Number or subclass.
// * **Lower bounded**: `List<? super Integer>` → Integer or superclass.

// ✅ Example:

// ```java
// void printNumbers(List<? extends Number> list) {
//     for (Number n : list) {
//         System.out.println(n);
//     }
// }
// ```

// ---

// ### 🔹 Generics with Collections

// * `Map<K, V>` → generic key-value

// ```java
// Map<String, Integer> scores = new HashMap<>();
// scores.put("Alice", 90);
// scores.put("Bob", 80);
// ```

// * Type safety avoids wrong key/value types.

// ---

// ### 🔹 Type Erasure

// * Java implements generics via **type erasure**.
// * Means at runtime, generics info is erased → only raw types remain.
// * Ensures **backward compatibility** with pre-Java-5 code.

// Example:

// ```java
// List<String> l1 = new ArrayList<>();
// List<Integer> l2 = new ArrayList<>();
// System.out.println(l1.getClass() == l2.getClass()); // true
// ```

// ---

// # ✅ Wrap-Up

// * **Exceptions**

//   * Try–catch–finally = handling mechanism.
//   * Checked (compile-time) vs Unchecked (runtime).
//   * Custom exceptions = domain-specific clarity.

// * **Generics**

//   * Compile-time type safety.
//   * Generic classes + methods → reusable.
//   * Bounded types, wildcards, collections.
//   * Implemented via type erasure.

// ---