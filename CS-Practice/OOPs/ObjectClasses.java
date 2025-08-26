// instanceof vs getClass() decision

// if (!(o instanceof MyClass)) allows equality across subclasses (polymorphic equality). This can break symmetry if subclasses add fields and override equals differently.

// if (o == null || o.getClass() != getClass()) (i.e., getClass() check) enforces equality only between exact same runtime class — safer for mutable value objects and recommended unless you really need cross-class equality.

// Rule of thumb: make the class final or prefer getClass() check to avoid subtle symmetry issues.




// The `Object` class in Java is the root of the class hierarchy. Every class in Java, directly or indirectly, inherits from `java.lang.Object`. 
// This class provides a set of methods that are available to all Java objects, enabling fundamental behaviors such as string representation, 
// equality comparison, and hashing. Understanding these methods is critical for advanced Object-Oriented Programming (OOP) in Java, 
// as they are often overridden to customize object behavior. Below, I’ll explain the key `Object` class methods in depth, including their purpose, 
// default behavior, and how to override them effectively, with examples and best practices.

//  1. `toString()`
//  Purpose
// The `toString()` method provides a string representation of an object. It’s commonly used for debugging, logging, or displaying object information in a human-readable format.

//  Signature
// ```java
// public String toString()
// ```

//  Default Behavior
// The default implementation in the `Object` class returns a string in the format:
// ```
// getClass().getName() + "@" + Integer.toHexString(hashCode())
// ```
// - `getClass().getName()`: The fully qualified name of the class (e.g., `java.lang.Object` or `com.example.MyClass`).
// - `Integer.toHexString(hashCode())`: The hexadecimal representation of the object’s hash code.

// For example:
// ```java
// Object obj = new Object();
// System.out.println(obj.toString()); // Output: java.lang.Object@1b6d3586
// ```

// This default output is not very informative, as it only provides the class name and a memory address-like hash code.

//  Why Override `toString()`?
// Overriding `toString()` allows you to provide a meaningful string representation of your object’s state, making it easier to debug or log information.

//  How to Override
// When overriding `toString()`, return a string that represents the object’s key attributes in a clear, readable format. For example:

// ```java
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     @Override
//     public String toString() {
//         return "Person{name='" + name + "', age=" + age + "}";
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Person person = new Person("Alice", 30);
//         System.out.println(person); // Implicitly calls toString()
//         // Output: Person{name='Alice', age=30}
//     }
// }
// ```

//  Best Practices
// - Include Key Fields: Represent the most relevant fields that define the object’s state.
// - Be Concise: Avoid overly verbose output, but include enough detail for clarity.
// - Use Consistently: Ensure the format is consistent across classes in your application.
// - Avoid Side Effects: The `toString()` method should not modify the object’s state or perform complex computations.
// - Consider Tools: Libraries like Apache Commons’ `ToStringBuilder` or Lombok’s `@ToString` annotation can simplify `toString()` generation.

//  Common Use Cases
// - Debugging: Print object details in logs.
// - User Interface: Display object data in a readable format.
// - Serialization: Provide a string-based representation for persistence or transmission.



//  2. `equals(Object obj)`
//  Purpose
// The `equals()` method determines whether two objects are logically equal, based on their content rather than their memory address.

//  Signature
// ```java
// public boolean equals(Object obj)
// ```

//  Default Behavior
// The default implementation in `Object` checks for reference equality (i.e., whether the two references point to the same object in memory using `==`):
// ```java
// public boolean equals(Object obj) {
//     return (this == obj);
// }
// ```

// For example:
// ```java
// Object obj1 = new Object();
// Object obj2 = new Object();
// System.out.println(obj1.equals(obj2)); // Output: false (different objects)
// System.out.println(obj1.equals(obj1)); // Output: true (same object)
// ```

//  Why Override `equals()`?
// The default implementation only checks if two references are identical, which is rarely useful for custom classes where logical equality (based on field values) is needed. For example, two `Person` objects with the same `name` and `age` might be considered equal even if they are distinct objects in memory.

//  How to Override
// When overriding `equals()`, follow these principles (based on the `equals` contract in Java):
// 1. Reflexive: `x.equals(x)` must return `true`.
// 2. Symmetric: If `x.equals(y)` is `true`, then `y.equals(x)` must also be `true`.
// 3. Transitive: If `x.equals(y)` and `y.equals(z)` are `true`, then `x.equals(z)` must be `true`.
// 4. Consistent: Multiple calls to `x.equals(y)` should return the same result if the objects’ state hasn’t changed.
// 5. Null Check: `x.equals(null)` must return `false`.

// Here’s an example:
// ```java
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         // Check for reference equality
//         if (this == obj) return true;
        
//         // Check for null and type compatibility
//         if (obj == null || getClass() != obj.getClass()) return false;
        
//         // Cast and compare fields
//         Person other = (Person) obj;
//         return age == other.age && 
//                (name == null ? other.name == null : name.equals(other.name));
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Person p1 = new Person("Alice", 30);
//         Person p2 = new Person("Alice", 30);
//         Person p3 = new Person("Bob", 25);
        
//         System.out.println(p1.equals(p2)); // Output: true
//         System.out.println(p1.equals(p3)); // Output: false
//         System.out.println(p1.equals(null)); // Output: false
//     }
// }
// ```

//  Key Considerations
// - Type Checking: Use `getClass()` for strict type checking or `instanceof` for polymorphic equality (if subclasses are allowed to be equal).
// - Null Safety: Handle `null` fields carefully, as shown in the example.
// - Field Comparison: Use appropriate comparison methods (e.g., `equals()` for objects like `String`, `==` for primitives).
// - Consistency with `hashCode()`: If `equals()` is overridden, `hashCode()` must also be overridden to maintain the contract (discussed below).

//  Best Practices
// - Use `instanceof` for Flexibility: If subclasses should be considered equal, use `instanceof` instead of `getClass()`.
// - Handle Nulls: Always check for `null` to avoid `NullPointerException`.
// - Use Libraries: Tools like Apache Commons’ `EqualsBuilder` or Lombok’s `@EqualsAndHashCode` can automate `equals()` implementation.
// - Test Thoroughly: Verify the `equals()` contract with unit tests for edge cases (e.g., `null`, same object, different types).



//  3. `hashCode()`
//  Purpose
// The `hashCode()` method returns an integer hash code for an object, used by hash-based collections like `HashMap`, `HashSet`, and `Hashtable` to efficiently store and retrieve objects.

//  Signature
// ```java
// public int hashCode()
// ```

//  Default Behavior
// The default implementation in `Object` returns a unique integer, typically derived from the object’s memory address (though the exact implementation is JVM-dependent). This ensures that distinct objects generally have different hash codes.

// For example:
// ```java
// Object obj = new Object();
// System.out.println(obj.hashCode()); // Output: some integer (e.g., 1109371623)
// ```

//  Why Override `hashCode()`?
// If you override `equals()`, you must override `hashCode()` to maintain the general contract:
// - Consistency with `equals()`: If two objects are equal according to `equals()`, they must have the same `hashCode()`.
// - Consistency: Multiple calls to `hashCode()` on the same object must return the same value, provided no fields used in `equals()` change.
// - Efficiency: A good `hashCode()` method distributes objects evenly across a hash table to minimize collisions.

// Failing to override `hashCode()` when overriding `equals()` can break hash-based collections. For example, a `HashSet` might not recognize two equal objects as duplicates.

//  How to Override
// A good `hashCode()` implementation combines the hash codes of the object’s significant fields (those used in `equals()`). Here’s an example consistent with the `Person` class above:

// ```java
// class Person {
//     private String name;
//     private int age;

//     public Person(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null || getClass() != obj.getClass()) return false;
//         Person other = (Person) obj;
//         return age == other.age && 
//                (name == null ? other.name == null : name.equals(other.name));
//     }

//     @Override
//     public int hashCode() {
//         int result = 17; // Prime number as initial value
//         result = 31 * result + (name == null ? 0 : name.hashCode());
//         result = 31 * result + age;
//         return result;
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Person p1 = new Person("Alice", 30);
//         Person p2 = new Person("Alice", 30);
        
//         HashSet<Person> set = new HashSet<>();
//         set.add(p1);
//         set.add(p2);
        
//         System.out.println(set.size()); // Output: 1 (p1 and p2 are equal)
//         System.out.println(p1.hashCode() == p2.hashCode()); // Output: true
//     }
// }
// ```

//  HashCode Algorithm
// - Start with a prime number (e.g., 17) to reduce collisions.
// - For each significant field:
//   - Multiply the current result by a prime number (e.g., 31) to ensure good distribution.
//   - Add the field’s hash code (use `0` for `null` objects, `hashCode()` for objects, or the value for primitives).
// - The formula `result = 31 * result + fieldHash` is commonly used because 31 is a prime number and has efficient multiplication properties (e.g., `31 * x` can be optimized as `(x << 5) - x`).

//  Best Practices
// - Consistency with `equals()`: Ensure fields used in `hashCode()` match those in `equals()`.
// - Handle Nulls: Return `0` for `null` fields to avoid exceptions.
// - Use Primes: Prime numbers like 31 help reduce hash collisions.
// - Use Libraries: Apache Commons’ `HashCodeBuilder` or Lombok’s `@EqualsAndHashCode` can simplify implementation.
// - Test with Collections: Verify that objects work correctly in `HashMap`, `HashSet`, etc.

//  Common Issues
// - Inconsistent `equals()` and `hashCode()`: Leads to bugs in hash-based collections (e.g., objects not found in a `HashMap`).
// - Mutable Fields: If fields used in `hashCode()` change after an object is added to a hash-based collection, the object may become “lost” because its hash code changes.



//  4. `clone()`
//  Purpose
// The `clone()` method creates a copy of an object. It’s used to duplicate an object while allowing control over whether the copy is shallow or deep.

//  Signature
// ```java
// protected Object clone() throws CloneNotSupportedException
// ```

//  Default Behavior
// The default implementation performs a shallow copy, copying the object’s fields directly. For primitive fields, this copies the values; for reference fields, it copies the references, not the objects they point to.

//  Why Override `clone()`?
// - To support cloning, a class must implement the `Cloneable` interface (a marker interface).
// - Override `clone()` to customize the copying behavior, especially for deep copies (where referenced objects are also copied).

//  Example
// ```java
// class Person implements Cloneable {
//     private String name;
//     private int age;
//     private Address address; // Nested object

//     public Person(String name, int age, Address address) {
//         this.name = name;
//         this.age = age;
//         this.address = address;
//     }

//     @Override
//     protected Object clone() throws CloneNotSupportedException {
//         // Shallow copy
//         Person cloned = (Person) super.clone();
//         // Deep copy for address
//         cloned.address = new Address(this.address.getCity());
//         return cloned;
//     }
// }

// class Address {
//     private String city;

//     public Address(String city) {
//         this.city = city;
//     }

//     public String getCity() {
//         return city;
//     }
// }

// public class Main {
//     public static void main(String[] args) throws CloneNotSupportedException {
//         Person p1 = new Person("Alice", 30, new Address("New York"));
//         Person p2 = (Person) p1.clone();
        
//         System.out.println(p1 != p2); // Output: true (different objects)
//         System.out.println(p1.address != p2.address); // Output: true (deep copy)
//     }
// }
// ```

//  Best Practices
// - Implement `Cloneable`: Without it, `clone()` throws `CloneNotSupportedException`.
// - Deep vs. Shallow Copy: Decide whether a shallow copy is sufficient or a deep copy is needed.
// - Consider Alternatives: Cloning is complex and error-prone; consider copy constructors or factory methods instead.



//  5. `finalize()`
//  Purpose
// The `finalize()` method is called by the garbage collector before an object is reclaimed. It’s used to perform cleanup (e.g., releasing resources).

//  Signature
// ```java
// protected void finalize() throws Throwable
// ```

//  Default Behavior
// The default implementation does nothing.

//  Why Override?
// Rarely overridden, as it’s deprecated since Java 9 and removed in later versions. Instead, use `try-with-resources` or `Cleaner` for resource management.

//  Best Practices
// - Avoid `finalize()`: Use explicit resource management (e.g., `close()` methods or `try-with-resources`).
// - Use `Cleaner`: For modern Java, use the `java.lang.ref.Cleaner` class for cleanup tasks.



//  6. `getClass()`
//  Purpose
// Returns the runtime class of the object.

//  Signature
// ```java
// public final Class<?> getClass()
// ```

//  Default Behavior
// Returns a `Class` object representing the object’s class. It’s `final`, so it cannot be overridden.

//  Use Case
// Used in reflection or to check an object’s type (e.g., in `equals()`).

// ```java
// Object obj = new Person("Alice", 30);
// System.out.println(obj.getClass().getName()); // Output: Person
// ```



//  7. `wait()`, `notify()`, and `notifyAll()`
//  Purpose
// These methods are used for inter-thread communication, allowing threads to wait for conditions or signal other threads.

//  Signatures
// ```java
// public final void wait() throws InterruptedException
// public final void wait(long timeout) throws InterruptedException
// public final void notify()
// public final void notifyAll()
// ```

//  Default Behavior
// - `wait()`: Causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the same object.
// - `notify()`: Wakes up one waiting thread.
// - `notifyAll()`: Wakes up all waiting threads.

//  Usage
// Used in synchronized blocks for thread coordination. Example:

// ```java
// class SharedResource {
//     private boolean ready = false;

//     public synchronized void produce() throws InterruptedException {
//         ready = true;
//         notify();
//     }

//     public synchronized void consume() throws InterruptedException {
//         while (!ready) {
//             wait();
//         }
//         System.out.println("Consumed");
//     }
// }
// ```

//  Best Practices
// - Use in Synchronized Blocks: These methods must be called within a `synchronized` block or method.
// - Prefer Higher-Level Concurrency: Use `java.util.concurrent` utilities (e.g., `Lock`, `Condition`) instead of low-level `wait()`/`notify()`.



//  Summary Table

// | Method                     | Purpose                              | Default Behavior                              | Should Override? |
// |----------------------------|--------------------------------------|----------------------------------------------|------------------|
// | `toString()`               | String representation                | Class name + hash code                       | Yes              |
// | `equals(Object)`           | Logical equality                     | Reference equality (`==`)                    | Yes              |
// | `hashCode()`               | Hash code for collections            | Memory-based integer                         | Yes              |
// | `clone()`                  | Object copying                       | Shallow copy                                 | Sometimes        |
// | `finalize()`               | Cleanup before GC                    | Does nothing                                 | No (deprecated)  |
// | `getClass()`               | Get runtime class                    | Returns `Class` object                       | No (final)       |
// | `wait()`/`notify()`        | Thread synchronization               | Thread coordination                          | Rarely           |



//  Best Practices for Overriding `Object` Methods
// 1. Consistency: Ensure `equals()` and `hashCode()` are consistent.
// 2. Null Safety: Handle `null` values in `equals()` and `hashCode()`.
// 3. Immutability: Avoid using mutable fields in `equals()` and `hashCode()` to prevent issues in collections.
// 4. Testing: Write unit tests to verify the `equals()` and `hashCode()` contracts.
// 5. Use Libraries: Leverage tools like Lombok or Apache Commons to reduce boilerplate code.
// 6. Documentation: Clearly document the behavior of overridden methods, especially for `toString()`.



//  Advanced Considerations
// - Performance: Optimize `hashCode()` for minimal collisions in large collections.
// - Polymorphism: Decide whether `equals()` should allow subclass comparisons (using `instanceof` vs. `getClass()`).
// - Thread Safety: Ensure thread-safe behavior if objects are used in concurrent environments.
// - Immutability: Prefer immutable objects to avoid issues with changing fields after insertion into collections.

// By mastering these `Object` class methods, you can create robust, efficient, and maintainable Java classes that integrate well with Java’s collections and frameworks. Let me know if you’d like further clarification or additional examples!