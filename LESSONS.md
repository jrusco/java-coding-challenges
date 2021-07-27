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
