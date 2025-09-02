// Perfect — you want the complete list of design patterns with detailed information 📘
// Let’s go through them in an organized manner based on the Gang of Four (GoF) classification.

// ---

//  🧩 Design Patterns Overview

// The GoF book (Design Patterns: Elements of Reusable Object-Oriented Software, 1994) defined 23 classic patterns, grouped into:

// 1. Creational Patterns → object creation
// 2. Structural Patterns → object composition
// 3. Behavioral Patterns → object interaction/communication

// ---

//  🔹 1. Creational Patterns (5)

// Concerned with object creation mechanisms.

//  1. Singleton

//  Intent: Ensure a class has only one instance, and provide global access.
//  Example use: Logger, configuration manager, DB connection.
//  SOLID risk: Can violate SRP by managing both logic & lifecycle.

// ---

//  2. Factory Method

//  Intent: Define an interface for creating an object, but let subclasses decide which class to instantiate.
//  Example use: Different shapes (`Circle`, `Square`), parser objects.
//  Benefit: Encapsulates object creation.

// ---

//  3. Abstract Factory

//  Intent: Provide an interface for creating families of related objects without specifying concrete classes.
//  Example use: UI Toolkit (WindowsFactory → WinButton, WinCheckbox; MacFactory → MacButton, MacCheckbox).
//  Benefit: Keeps consistency across related objects.

// ---

//  4. Builder

//  Intent: Separate complex object construction from representation.
//  Example use: Building `Car` objects step by step (engine, seats, GPS).
//  Benefit: Different representations with same construction process.

// ---

//  5. Prototype

//  Intent: Create new objects by copying existing ones (cloning).
//  Example use: Document templates, game objects.
//  Benefit: Avoids costly initialization.

// ---

//  🔹 2. Structural Patterns (7)

// Concerned with class/object composition (how they’re structured).

//  6. Adapter

//  Intent: Convert the interface of a class into another interface clients expect.
//  Example use: Plug adapter (US to EU socket), legacy API integration.
//  Benefit: Allows reuse of existing classes with incompatible interfaces.

// ---

//  7. Bridge

//  Intent: Decouple abstraction from implementation so both can vary independently.
//  Example use: Shape class (Circle, Square) separated from rendering (OpenGL, DirectX).
//  Benefit: Avoids class explosion by separating hierarchies.

// ---

//  8. Composite

//  Intent: Treat individual objects and compositions (trees) uniformly.
//  Example use: File system (File vs Folder), UI elements (Button vs Panel).
//  Benefit: Recursive structures made easy.

// ---

//  9. Decorator

//  Intent: Add behavior to objects dynamically without altering their class.
//  Example use: Coffee → with milk, with sugar.
//  Benefit: More flexible than inheritance.

// ---

//  10. Facade

//  Intent: Provide a simplified interface to a complex subsystem.
//  Example use: `Computer.start()` hides details of CPU, RAM, Disk startup.
//  Benefit: Reduces complexity for clients.

// ---

//  11. Flyweight

//  Intent: Share common object data to minimize memory use.
//  Example use: Rendering 1,000,000 trees in a game → store only shared data.
//  Benefit: High performance in memory-constrained systems.

// ---

//  12. Proxy

//  Intent: Provide a placeholder/surrogate for another object to control access.
//  Types: Virtual Proxy, Remote Proxy, Protection Proxy.
//  Example use: Lazy-loading an image, security proxy for resources.
//  Benefit: Control access without changing target object.

// ---

//  🔹 3. Behavioral Patterns (11)

// Concerned with algorithms & communication between objects.

//  13. Chain of Responsibility

//  Intent: Pass a request along a chain until one handler processes it.
//  Example use: Logging levels, event handling.
//  Benefit: Decouples sender & receiver.

// ---

//  14. Command

//  Intent: Encapsulate a request as an object → parameterize clients.
//  Example use: Undo/Redo operations, queue requests.
//  Benefit: Decouples invoker from receiver.

// ---

//  15. Interpreter

//  Intent: Define grammar & interpreter for a language.
//  Example use: Regular expressions, math expression evaluation.
//  Benefit: Easy to implement small languages.

// ---

//  16. Iterator

//  Intent: Sequentially access elements of a collection without exposing its representation.
//  Example use: `Iterator` in Java Collections (`.hasNext()`, `.next()`).
//  Benefit: Uniform traversal for different collections.

// ---

//  17. Mediator

//  Intent: Define an object that encapsulates communication between objects.
//  Example use: Air traffic control, chat room server.
//  Benefit: Reduces coupling (no direct references between components).

// ---

//  18. Memento

//  Intent: Capture and restore an object’s internal state without exposing it.
//  Example use: Undo functionality in text editor.
//  Benefit: Preserves encapsulation.

// ---

//  19. Observer

//  Intent: One-to-many dependency → notify observers on state change.
//  Example use: Event listeners, stock price updates.
//  Benefit: Loose coupling.

// ---

//  20. State

//  Intent: Allow an object to change its behavior when its internal state changes.
//  Example use: Vending machine (HasCoin, NoCoin states).
//  Benefit: Replaces long conditional statements.

// ---

//  21. Strategy

//  Intent: Define a family of algorithms, encapsulate them, and make them interchangeable.
//  Example use: Sorting algorithms, payment methods.
//  Benefit: Follows OCP (add new strategies without modifying).

// ---

//  22. Template Method

//  Intent: Define skeleton of algorithm, let subclasses override steps.
//  Example use: Abstract class for `Game` → `start()`, `play()`, `end()`.
//  Benefit: Promotes code reuse.

// ---

//  23. Visitor

//  Intent: Represent an operation to be performed on elements of a structure.
//  Example use: Tax calculation for different product types.
//  Benefit: Add new operations without changing object classes.

// ---

//  📊 Summary Table of All Design Patterns

// | Category            | Pattern Names                                                                                                                   |
// | ------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
// | Creational (5)      | Singleton, Factory Method, Abstract Factory, Builder, Prototype                                                                 |
// | Structural (7)      | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy                                                                 |
// | Behavioral (11)     | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor |

// ---

// 👉 These 23 are the core GoF patterns.
// There are also modern patterns (like Dependency Injection, Repository, MVC, MVVM) which evolved later.

