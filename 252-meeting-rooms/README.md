## Leetocode - 252: Meeting Rooms

## [Meeting Rooms](https://www.lintcode.com/problem/920/)


**Difficulty:** Easy

**Topics:** Array, Sorting, Greedy, Interval

## Problem Statement

## Description
You are given an array of meeting time intervals `intervals` where `intervals[i] = [start_i, end_i]`, representing the start and end times of the i-th meeting. Determine if a person could attend all meetings.

(Given an array of meeting time intervals consisting of start and end times `[(s1,e1),(s2,e2),...]` `(si < ei)`, determine if a person could attend all meetings.)


### Example 1:  
**Input:** `intervals = [[0, 30], [5, 10], [15, 20]]`  
**Output:** false  
**Explanation:** A person cannot attend both the meeting `[0, 30]` and `[5, 10]` since they overlap.  


### Example 2:  
**Input:** `intervals = [[7, 10], [2, 4]]`  
**Output:** true  
**Explanation:** Since none of the meetings overlap, the person can attend all.



### Constraints:
- <code>0 <= intervals.length <= 10<sup>4</sup></code>
- `intervals[i].length == 2`
- <code>0 <= start_i <= end_i <= 10<sup>6</sup></code>
- `[(0,8), (8,10)]` is not conflict(overlap) at 8.