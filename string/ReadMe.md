## <center>字符串</center>

## 部分例题

### [3.Longest Substring Without Repeating Characters](./3.longest-substring-without-repeating-characters.java)

- 题目描述

  Given a string, find the length of the **longest substring** without repeating characters.

  **Example 1:**

  ```java
  Input: "abcabcbb"
  Output: 3 
  Explanation: The answer is "abc", with the length of 3. 
  ```

  **Example 2:**

  ```java
  Input: "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.
  ```

- 思路

  利用双指针的思想，leftPointer和rightPointer代表substring的边界。主要步骤：
  
  - 保持leftPointer不变，不断更新rightPointer，此时[leftPointer,rightPointer]表示当前以rightPointer结尾的字串。
  - 查询rightPointer对应的字符是否出现过，若出现过，则更新leftPointer至rightPointer上次出现位置的下一个位置，为了防止leftPointer回退（因为上次出现的位置可能在leftPointer的前面），因此对上一位置与leftPointer当前位置进行比较，选取较大的值。换种思考方式其实就是如果rightPointer的元素在leftPointer前面出现，则不用管，因为当前的substring不包含该元素，若在leftPointer后面，则在当前的substring中，要进行更新。
  - 更新当前长度
  - 更新rightPointer
  
  

### [5.Longest Palindromic Substring](./5.longest-palindromic-substring.java)

- 题目描述

  Given an input string (`s`) and a pattern (`p`), implement regular expression matching with support for `'.'` and `'*'`.

  ```
  '.' Matches any single character.
  '*' Matches zero or more of the preceding element.
  ```

  The matching should cover the **entire** input string (not partial).

  **Note:**

  - `s` could be empty and contains only lowercase letters `a-z`.
  - `p` could be empty and contains only lowercase letters `a-z`, and characters like `.` or `*`.

  **Example 1:**

  ```java
  Input:
  s = "aa"
  p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".
  ```

  **Example 2:**

  ```java
  Input:
  s = "aa"
  p = "a*"
  Output: true
  Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
  ```

  **Example 3:**

  ```java
  Input:
  s = "ab"
  p = ".*"
  Output: true
  Explanation: ".*" means "zero or more (*) of any character (.)".
  ```

  **Example 4:**

  ```java
  Input:
  s = "aab"
  p = "c*a*b"
  Output: true
  Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
  ```

  **Example 5:**

  ```java
  Input:
  s = "mississippi"
  p = "mis*is*p*."
  Output: false
  ```

- 思路
  
  - 

### [10.Regular Expression Matching](./10.regular-expression-matching.java)

- 题目描述

  

- 思路

  首先进行数组的遍历，同时维护一个下标窗口来保存窗口的最大值。总体的思路为：
  将失效元素的下标移除。如遍历到第五个元素，窗口值为3时候，此时最大值只可能出现在3，4，5中，将0，1，2称为失效元素。**因为每次只滑动一个值，因此每次也只有一个元素失效，所以这边用if代替while**
  第二步是判断当前元素与已经遍历元素的关系，若之前的元素比当前元素小，则之前元素没有资格成为当前窗口的最大值，因此将之前元素下标移除。
  判断是否到达一个窗口的极限，若此时到了一个窗口的边界，则将此时的最大值（在队头）存入结果中。

### [14.Longest Common Prefix](./14.longest-common-prefix.java)

- 题目描述

  Write a function to find the longest common prefix string amongst an array of strings.

  If there is no common prefix, return an empty string `""`.

  **Example 1:**

  ```java
  Input: ["flower","flow","flight"]
  Output: "fl"
  ```

  **Example 2:**

  ```java
  Input: ["dog","racecar","car"]
  Output: ""
  Explanation: There is no common prefix among the input strings.
  ```

- 思路

  因为要是前缀，所以必须要从第一个元素开始就要相同。因此大体思路是使用第一个元素作为prefix也就是结果，然后对后面的每个元素进行遍历查看前缀是否与prefix一致，若不一致则将prefix的最后一位discard掉继续比较直到prefix为空字符串或者匹配到。

  

### [17.Letter Combinations of a Phone Number](./17.letter-combinations-of-a-phone-number.java)

- 题目描述

  

- 思路

  - 

### [20.Valid Parentheses)[./20.valid-parentheses.java]

- 题目描述

  Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

  An input string is valid if:

  1. Open brackets must be closed by the same type of brackets.
  2. Open brackets must be closed in the correct order.

  Note that an empty string is also considered valid.

  **Example:**

  ```java
  Input: "()"
  Output: true
    
  Input: "()[]{}"
  Output: true
    
  Input: "(]"
  Output: false
  ```
  
- 思路

  利用栈的思想。遇到开始的符号将对应的结束符号入栈，当遇到结束符号时候看栈顶元素是否与此符号相等。


### [22.Generate Parentheses](./22.generate-parentheses.java)

- 题目描述

  

  **Example:**

  ```java

  ```
  
- 思路




### [28.Implement strStr()](./28.implement-str-str.java)

- 题目描述
- 思路

### [44.Wildcard Matching](./44.wildcard-matching.java)

- 题目描述
- 思路

### [49.Group Anagrams](./49.group-anagrams.java)

- 题目藐视
- 思路

### [76.Minimum Window Substring](./76.minimum-window-substring.java)

- 题目描述
- 思路

### [91.Decode Ways](./91.decode-ways.java)

- 题目描述
- 思路

### [125.Valid Palindrome](./125.valid-palindrome.java)

- 题目描述
- 思路

### [227.Basic Calculator II](./227.basic-calculator-ii.java)

- 题目描述
- 思路

### [344.Reverse String](./344.reverse-string.java)

- 题目描述

  Write a function that reverses a string. The input string is given as an array of characters `char[]`.

  Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with O(1) extra memory.

  You may assume all the characters consist of [printable ascii characters](https://en.wikipedia.org/wiki/ASCII#Printable_characters).

  **Example :**

  ```java
  Input: ["h","e","l","l","o"]
  Output: ["o","l","l","e","h"]
  
  Input: ["H","a","n","n","a","h"]
  Output: ["h","a","n","n","a","H"]
  ```

  

- 思路

  利用双指针，一个指向开头一个指向结尾。交换对应元素即可。

### [387First Unique Character in a String](./387.first-unique-character-in-a-string.java)

- 题目描述

  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

  **Examples:**

  ```java
  s = "leetcode"
  return 0.
  
  s = "loveleetcode",
  return 2.
  ```

  **Note:**You may assume the string contain only lowercase letters.

  

- 思路

  因为只包含小写字母，因此只要申请长度为26的数组，遍历字符串，在对应的位置(字符-'a')记录字符出现的频次。

  遍历字符串的每一个字符，找到第一个频次为1的字符返回下标。

