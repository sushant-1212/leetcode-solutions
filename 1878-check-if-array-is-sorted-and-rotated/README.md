## My Approach

I check the array in a circular way and count how many times the order is broken.

For every element, I compare it with the next element:

```java
nums[i] > nums[(i + 1) % n]
```

If this condition is true, it means the increasing order is broken, so I increment `count`.

A sorted array has **0 break points**, while a sorted array that has been rotated can have **exactly 1 break point**.

So, if the number of break points is more than `1`, the array cannot be sorted and rotated.

Therefore, I return:

```java
return count <= 1;
```

`(i + 1) % n` is used to compare the last element with the first element, making the array circular.

