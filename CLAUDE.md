# CLAUDE.md — java-coding-challenges

## Project Overview
- Maven, Java 21, JUnit 4
- All implementation code lives **inside test files** — no src/main logic
- Package split: `com.jrusco.leetcode` (core challenges) · `com.jrusco.demo` (company-specific prep)

---

## Test File Conventions
- File and class: `{ProblemName}Test.java`
- **Template**: copy `src/test/java/com/jrusco/leetcode/SampleTest1.java`, rename it, update the package declaration and class name — do not create from scratch
- Javadoc block at the top: LeetCode URL on line 1, blank line, problem statement, blank line, `== My Notes ==` section (leave blank until solved)
- One `@Test public void test()` method per file
- Assertions (JUnit 4 — no Hamcrest): `assertEquals(expected, actual)`, `assertTrue`, `assertFalse`, `assertArrayEquals`
- Solution method goes directly in the test class, below the `@Test` method — no separate source files

---

## Housekeeping Checklist
Housekeeping = stub → ready to implement. Stop before writing the algorithm.

**When asked to do housekeeping on a file, follow these steps in order:**

### 1. URL
Confirm the Javadoc URL matches the actual problem. Fix if it is a placeholder.

### 2. Inner Classes
If the problem uses a linked-list or tree node, define the inner class inside the test class. Never leave it as a comment block.

### 3. Method Signature
Ensure the solution method accepts the correct parameter types (`TreeNode`, `ListNode`, `int[]`, etc.) and returns the correct type. Fix any template mismatch.

### 4. Test Cases
Replace placeholder calls with real examples from the problem's commented `// Input: ... Output: ...` blocks:
- Construct inputs explicitly — no shortcut helpers
- **Trees**: LeetCode uses BFS level-order — root is index 0, left child at `2i+1`, right child at `2i+2`; `null` occupies a slot and shifts subsequent values rightward
- Use the assertion that matches the return type
- Cover all provided examples;

### 5. Stub
Leave the method body returning the zero-value for its type (`return false;`, `return null;`, `return 0;`, `return "";`). Do not implement the algorithm.

---

## Running Tests
Maven isn't discoverable from the sandbox. User needs to run the test with `mvn test -Dtest={ProblemName}Test` from the devcontainer.

