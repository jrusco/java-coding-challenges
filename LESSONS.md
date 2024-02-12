# Approach to solving Leetcode challenges

1. Start with the top 100 liked Qs
2. Focus on Qs by topic. Don't tackle Qs at random.
3. Order the Qs from highest to lowest acceptance rate.
4. Learn from the solutions. Don't be afraid to peek at the proposed solutions. Make notes from what you learned in each exercise, and dont spend more than 45 mins in a single challenge. If stuck, move on and come back later.
5. Revisit the problems. You probably will forget how to solve some problems after a week, so make sure to study them periodically.
6. Optional: Try company-specific challenge lists (paid feature) once you get the hang of the different kinds of problems and before feeling ready to apply to any of those companies.

## Suggested topic order
In order of importance, relevance and frequency

* String
* Two pointers
* Sliding window
* Binary Search
* Recursion 
* Binary Tree
* Backtracking
* DFS
* BFS
* Graph
* Linked List
* Sort
* Trie
* Stack/Queue
* Priority Queue
* Dynamic Programming

# What did I learn from each exercise

### RemoveElementTest

* The proposed solution only cares about the response and not how the input array's final state. This is either the author's mistake or noise in the problem description.
* the `++` operand on a int, when used as index of array, will operate with the current value and then increment.
* Changing the values of items in array while iterating over it: 
    * wont throw an error
    * will leave the unnasigned items at the default value (for int is 0), even if the original array had set values for those items.

### ClimbingStairsTest

* Basics of dinamyc programming. Solving the challenge using bottom-up approach.

### RotateArrayTest

* Identify the portions of the array ("subproblems") that'd have to be swapped in order to come up with the right response. In this scenario, we can always say that the result can always be obtained by moving subarray `nums[k to n]` before `nums[0 to k-1]`.
* If I can figure out, beforehand, what's the final position the items should be at to have a correct response, then I don't need to cycle `k` times through the array to move them into place. In addition, identifying a bottom-up approach will make the solution easier and leaner.

### BalancedStringsTest

* As only two possible values exist for characters, `R` and `L`, the easiest way to compare them is to assign them possitive and negative values while traversing the char array. This makes the comparison a lot simpler and more performant than asserting the literal values themselves.

### AddStringsTest

* When dealing with digit that are in variables of type `char`, doing math operations such as `-` or `+` will treat them as the `int` value representing their position in the ASCII table. I.e. you can use this to convert from `String`, `char` to `int` by doing `'5' - '0'` (will return an int value of `5`)

### RangeSumBstTest

* DFS can be implemented iteratively by storing objects in a `Stack` or `Queue`

### ValidMountainArrayTest

* In excersices like this, the actual value of the items aren't the key to solve the problem, but the value **changes** are.
* An efficient way of solving this challenge could involve trying to find the index where the array reaches it highest value before starting to decrease.
* if `i==0` or `i==arr.lenght -1` then is not a valid mountain array because either is starting with the highes value, or is only increasing it, or there are values that are equal (which is a constraint in this case). 

### MergeTwoSortedListsTest

* A Linked list composed of a custom class such as `ListNode` calls for storing a reference the list head (its first item) so it is possible to return the whole list later.
* Iterating over the linked list with `node.next` seems counterintuitive as each `node` is overwritten by its next value. But by having a pointer to the very first node of the list, I'm able to return it in its enterity after having built it from merging `l1` and `l2`.
