# LeetCode 234.[回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

## 题目

给你一个单链表的头节点 `head` ，请你判断该链表是否为回文链表。如果是，返回 `true` ；否则，返回 `false` 。

**进阶：**你能否用 `O(n)` 时间复杂度和 `O(1)` 空间复杂度解决此题？

## 思路

回文串的特征是从头到尾与从尾到头遍历的值一一对应相等，如12321，给定一条数据如果符合这个特征即可判断它是回文串。

### 解法一：栈

#### 描述

如果不考虑空间复杂度，这个问题就非常的简单，新建一个栈，遍历一遍链表，将数据压入栈中，再重新遍历一次链表并且数据出栈，如果值不相等，则不是回文串，如果全相等，则是回文串。

#### 代码

```java
    public boolean isPalindrome(ListNode head) {
        ListNode flag = head;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != flag.val) {
                return false;
            }
            flag = flag.next;
        }
        return true;
    }
```



### 解法二：三指针

#### 描述

一眼看到题目时第一种解法思路就出来了，但我想考虑进阶版的解法，凭借以往经验，知道肯定要用指针遍历，于是想到了这种解法。

1. 声明两个指针flag1和flag2，包含头指针就一共有3个指针；

2. 第一次遍历，让头指针去到末尾，下面改称为尾指针；

3. 第二次遍历，重新遍历一次链表，将链表结点依次插入到尾指针后面；

4. 通过第二次遍历，在原链表后面再重新拼接了一个倒序的链表，根据回文串的特征，进行第三次遍历，从头开始与插入的点一一比对

   ![微信图片_20220224181347](https://cdn.jsdelivr.net/gh/jonnyou/images/upload/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220224181347.jpg)

刚想到时觉得还不错，至少时间复杂度降到了O(n)，但是我忽略了空间复杂度，因为新增结点占据了一定内存。

#### 代码

```java
    public boolean isPalindrome(ListNode head) {
        ListNode flag1 = head, flag2 = head;

        while (head.next != null) {
            head = head.next;
        }

        while (flag1 != head) {
            ListNode node = new ListNode(flag1.val);
            ListNode flag = head.next;
            head.next = node;
            node.next = flag;
            flag1 = flag1.next;
        }

        while (flag2 != head) {
            if (flag2.val != flag1.val) {
                return false;
            }
            flag1 = flag1.next;
            flag2 = flag2.next;
        }

        return true;
    }
```

### 解法三：反向链表（进阶）

#### 描述

找到链表的中点，然后向后创建一个反向链表，然后从头与反向链表一一比对。时间复杂度空间复杂度都达到进阶版要求。

#### 代码	

```java
public boolean isPalindrome(ListNode head) {
        
        ListNode middle = findMiddle(head);
        ListNode reverseNode = reverse(middle);
        
        while (head != middle) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }
    
    // 寻找中点
    ListNode findMiddle(ListNode node) {
        ListNode middle = node;
        while (node != null && node.next != null) {
            middle = middle.next;
            node = node.next.next;
        }
        return middle;
    }
    
    // 创建反向链表
    ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode flag = node;
            node = node.next;
            flag.next = pre;
            pre = flag;
        }
        return pre;
    }
```

## 最后

这道题不难，首先需要知道回文串的含义，然后需要熟练单链表的操作。进阶版卡住我的是寻找中点，一开始我就想到如果能定位到中点，问题就很容易解决，但一下子没什么思路。后面看了题解，这种一次走两步的找法很妙。

传送门：https://leetcode-cn.com/problems/palindrome-linked-list/