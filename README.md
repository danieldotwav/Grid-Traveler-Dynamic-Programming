# Grid Traveler Using Dynamic Programming

## Introduction

This problem is a classic example of a combinatorial problem that aims to find the number of possible paths from the top-left corner to the bottom-right corner in an `m x n` grid, with the constraint of only moving right or down.

## Program Overview

The program includes two primary methods:

- `gridTraveler(int rows, int columns)`: A method to calculate the number of possible paths in a grid of size `rows x columns` using a recursive approach.
- `improvedGridTraveler(long rows, long columns, HashMap<String, Long> solutions)`: An optimized version of `gridTraveler` using dynamic programming with memoization for efficient calculation.

## Algorithms

### **1. Simple Recursive Method (`gridTraveler`):**

#### Logic

- **Base Cases**:
  - Return `0` if either `rows` or `columns` is `0` (invalid grid).
  - Return `1` for a `1x1` grid.
- For larger grids, recursively calculate moving right (decrease columns) and moving down (decrease rows).
- The total paths are the sum of these recursive calls.

#### Complexity Analysis

- **Time Complexity**: `O(2^(m+n))`, where `m` is the number of rows and `n` is the number of columns.
- **Space Complexity**: `O(m+n)`, due to the recursion stack depth.

### **2. Dynamic Programming with Memoization(`improvedGridTraveler`):**

#### Logic

- **Memoization**: Uses a `HashMap` to store results of subproblems.
- **Base Cases**: Similar to the recursive approach.
- **Key Generation**: Creates a unique key for each grid dimension.
- Return the stored value if the key exists in the map.
- Compute and store results for new keys.

#### Complexity Analysis

- **Time Complexity**: `O(m*n)`, more efficient than the recursive approach.
- **Space Complexity**: `O(m*n)`, for the memoization map.

## Improvements

- **Tail Recursion**: Optimize space complexity in the recursive approach.
- **Iterative Dynamic Programming**: Use an iterative approach for further space optimization.
- **Parallel Computing**: For large grids, employ parallel computing techniques.
