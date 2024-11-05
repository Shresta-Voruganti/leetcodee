## Leetcode - 1198: Find Smallest Common Element in All Rows

## [Find Smallest Common Element in All Rows](https://leetcode.ca/2019-03-12-1198-Find-Smallest-Common-Element-in-All-Rows/)


**Difficulty:** Medium

**Topics:**

## Problem Statement

## Description
Given an `m x n` matrix `mat` where every row is sorted in **strictly increasing** order, return *the* **smallest common element**  *in all rows*.

If there is no common element, return `-1`.


### Example 1:  
**Input:** mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]   
**Output:** 5    


### Example 2:    
**Input:** mat = [[1,2,3],[2,3,4],[2,3,5]]    
**Output:** 2    



### Constraints:  
- <code>m == mat.length</code>
- <code>n == mat[i].length</code>
- <code>1 <= m, n <= 500</code>
- <code>1 <= mat[i][j] <= 10<sup>4</sup></code>
- `mat[i]` is sorted in strictly increasing order.