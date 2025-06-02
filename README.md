# Assignment Set 2 – Algorithmic Problems (C++)

This repository contains C++ implementations for two problems:

1. N-Queens Problem Solver
2. Circular Dependency Checker in a Directed Graph

Both problems are implemented with efficient and standard algorithmic approaches.

---

## Q1: N-Queens Problem

### Problem

Place n queens on an n x n chessboard such that no two queens threaten each other. This means no two queens can be in the same row, column, or diagonal.

### Approach

The solution uses recursive backtracking. Queens are placed row by row, and each column placement is validated against previously placed queens. Diagonal conflicts are checked using the absolute difference between rows and columns.

A 1D vector is used to store column positions for each row. When a complete solution is found, it is converted into a list of strings representing the board.

### Example Output for n = 4

.Q..
...Q
Q...
..Q.

..Q.
Q...
...Q
.Q..


--------------------------------------------------------------------------------------

## Q2: Circular Dependency Checker

### Problem

Given n modules and a list of directed dependencies between them, determine if the dependency graph contains a cycle. Each dependency {a, b} means module a depends on module b.

### Approach

This is solved using depth-first search (DFS). Each node is marked with one of three states:

- 0: unvisited
- 1: currently visiting
- 2: visited and safe

If a node is visited again while in the visiting state (1), a cycle is detected. The graph is built using adjacency lists and the algorithm checks each component of the graph.

### Example
Input:
n = 4
edges = {{0,1}, {1,2}, {2,0}}


Output:
true
