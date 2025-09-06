// ## 🧩 Step 1: What is React(Super Quick Recap)

//     * React helps us build UI using ** components ** (small reusable blocks).
// * Each component can have ** state ** (data that changes).
// * Components can share data with each other using ** props **.

// But when your app gets bigger, passing props becomes painful → ** Context ** solves this.

// ---

// ## 🌍 Context Hook(useContext)

// 👉 Problem: Passing props down many levels(called "prop drilling").

// ### Example without Context:

// ```jsx
// function App() {
//   return <Parent username="Musharaf" />;
// }

// function Parent({ username }) {
//   return <Child username={username} />;
// }

// function Child({ username }) {
//   return <h1>Hello {username}</h1>;
// }
// ```

// Here, `username` is passed from App → Parent → Child.Annoying, right ?

// ### With Context:

// We create a ** Context ** and provide it to all children.

// ```jsx
// import React, { createContext, useContext } from "react";

// // Step 1: Create Context
// const UserContext = createContext();

// function App() {
//   return (
//     // Step 2: Wrap components with Provider
//     <UserContext.Provider value="Musharaf">
//       <Parent />
//     </UserContext.Provider>
//   );
// }

// function Parent() {
//   return <Child />;
// }

// function Child() {
//   // Step 3: Use Context directly (no props needed)
//   const username = useContext(UserContext);
//   return <h1>Hello {username}</h1>;
// }
// ```

// ✅ Now Child can directly access the username.

// ---

// ## 🚀 useMemo Hook

// 👉 Problem: Some functions are ** expensive(slow) ** and run again unnecessarily when component re - renders.
// 👉 Solution: `useMemo` caches the result.

// ### Example:

// ```jsx
// import React, { useState, useMemo } from "react";

// function App() {
//   const [count, setCount] = useState(0);
//   const [dark, setDark] = useState(false);

//   // Expensive calculation
//   const doubleCount = useMemo(() => {
//     console.log("Calculating...");
//     return count * 2;
//   }, [count]); // only re-run when 'count' changes

//   const themeStyle = {
//     backgroundColor: dark ? "black" : "white",
//     color: dark ? "white" : "black",
//   };

//   return (
//     <div style={themeStyle}>
//       <h1>Count: {count}</h1>
//       <h2>Double: {doubleCount}</h2>
//       <button onClick={() => setCount(count + 1)}>Increment</button>
//       <button onClick={() => setDark(!dark)}>Toggle Theme</button>
//     </div>
//   );
// }
// ```

// ✅ `doubleCount` is not recalculated when we only toggle theme.

// ---

// ## ⚡ useCallback Hook

// 👉 Problem: When passing ** functions ** as props, React re - creates them on every render → causes unnecessary re - renders in child components.
// 👉 Solution: `useCallback` memoizes the function.

// ### Example:

// ```jsx
// import React, { useState, useCallback } from "react";

// function App() {
//   const [count, setCount] = useState(0);

//   // useCallback memoizes the function
//   const increment = useCallback(() => {
//     setCount((c) => c + 1);
//   }, []); // function won't be recreated on every render

//   return (
//     <div>
//       <h1>Count: {count}</h1>
//       <Child increment={increment} />
//     </div>
//   );
// }

// function Child({ increment }) {
//   console.log("Child rendered");
//   return <button onClick={increment}>Increment</button>;
// }
// ```

// ✅ Without`useCallback`, `Child` would re - render unnecessarily.

// ---

// ## 🎯 Final Analogy:

// * ** Context ** → Sharing data with everyone without passing props.
// * ** useMemo ** → Remember the result of a slow calculation.
// * ** useCallback ** → Remember the function itself(avoid unnecessary re-renders).
