# Connect4Array — Optimal Solution Walkthrough

---

## Entry point — `connect4()`

```java
int[][] board = new int[6][7];
int[] heights = new int[7];
```

Two data structures. `board` is the 6×7 grid — Java initializes `int` arrays to `0`, so every cell starts empty. `heights` tracks the **next available row** per column — also starts at `0`, meaning every column's lowest row is free.

```java
for (int m = 0; m < moves.length; m++) {
    int col = moves[m];
    int row = heights[col]++;
```

For each move, grab the column. Then `heights[col]++` does two things in one expression: it reads the current height (the row where the disc lands), then immediately increments it so the next disc in this column lands one row higher. Without the `heights` array, you'd have to scan from row 0 upward every time — that's O(rows) per move. This makes it O(1).

```java
    int player = m % 2 == 0 ? 1 : 2;
    board[row][col] = player;

    if (checkWin(board, player, row, col)) {
        return player;
    }
}
return 0;
```

Player alternates by parity: even index = P1, odd index = P2. After placing, immediately check for a win — if one is found, return the winner right away. No need to process remaining moves. If the whole array is exhausted with no winner, return 0.

---

## `checkWin()` — 4 axes from the last disc

```java
return countAxis(board, player, row, col, 0,  1) >= 4   // horizontal
    || countAxis(board, player, row, col, 1,  0) >= 4   // vertical
    || countAxis(board, player, row, col, 1,  1) >= 4   // diagonal ↗
    || countAxis(board, player, row, col, 1, -1) >= 4;  // diagonal ↘
```

Each call passes a **direction vector** `(dr, dc)` — row delta and column delta. This is the key insight: instead of checking the whole board, you only check outward from the disc you just placed. The `||` short-circuits, so as soon as one axis hits 4 the rest aren't evaluated.

---

## `countAxis()` — bidirectional count

```java
return 1
    + countInDir(board, player, row, col,  dr,  dc)
    + countInDir(board, player, row, col, -dr, -dc);
```

The `1` counts the placed disc itself. Then it counts matching discs in the **positive direction** along the axis, plus the **negative direction** — that's why negating `dr` and `dc` is so clean. One method, both sides of the axis covered. If the total reaches 4, that's a win.

---

## `countInDir()` — walk one direction

```java
for (int i = 1; i <= 3; i++) {
    int r = row + i * dr;
    int c = col + i * dc;
    if (r < 0 || r >= 6 || c < 0 || c >= 7 || board[r][c] != player) break;
    count++;
}
```

Walks up to **3 steps** in one direction. At each step it multiplies the step index by the direction vector to get the next cell. It checks bounds first (`r < 0`, `r >= 6`, etc.) — this order matters because if bounds fail, the array access never happens, avoiding an `ArrayIndexOutOfBoundsException`. If the cell is out of bounds or belongs to the other player, stop. The loop caps at 3 because `countAxis` already contributes 1 for the placed disc, and 1 + 3 = 4.

---

## Complexity

| | Complexity | Reason |
|---|---|---|
| **Time** | O(n) | One pass through n moves. O(1) win check per move (4 axes × ≤3 steps). |
| **Space** | O(1) | Board is fixed 6×7. Heights array is fixed 7 entries. Both constant regardless of input size. |
