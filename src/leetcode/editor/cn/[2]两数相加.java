package leetcode.editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 7554 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import utils.ListNode;
import utils.TestIntArr;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution2 {

    public static void main(String[] args) {
        // int[] arr1 = {9,9,9,9,9,9,9};
        // int[] arr2 = {9,9,9,9};

        // int[] arr1 = {9};
        // int[] arr2 = {9,9};

        // int[] arr1 = {8,3,2};
        // int[] arr2 = {9,2,1};

        // int[] arr1 = {9, 9, 1};
        // int[] arr2 = {1};

        // int[] arr1 = {5};
        // int[] arr2 = {5};



        int[] arr1 = new TestIntArr().getIntArrExample();
        int[] arr2 = new TestIntArr().getIntArrExample();


        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);
        System.out.println(new Solution2().addTwoNumbers2(l1, l2));
    }
    
    
    // 法一
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode node = l1, preL1 = null;
        int flag = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + flag;
            if (val > 9) {
                l1.val = val % 10;
                flag = 1;
            } else {
                l1.val = val;
                flag = 0;
            }
            preL1 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            preL1.next = l2;
            l1 = preL1.next;
        }

        while (l1 != null && l1.next != null) {
            int val = l1.val + flag;
            if (val > 9) {
                l1.val = val % 10;
                flag = 1;
            } else {
                l1.val = val;
                flag = 0;
            }
            l1 = l1.next;
        }

        // 处理最后可能进1的情况
        if (l1 != null) {
            if (l1.val == 9 && flag == 1) {
                ListNode last = new ListNode(1);
                l1.val = 0;
                l1.next = last;
            } else {
                l1.val = flag + l1.val;
            }
        } else {
            if (flag == 1) {
                ListNode last = new ListNode(1);
                preL1.next = last;
            }
        }
        
        return node;
    }

    // 法2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = val1 + val2 + flag;
            flag = val > 9 ? 1 : 0;
            if (head == null) {
                head = tail = new ListNode(val % 10);
            } else {
                tail.next = new ListNode(val % 10);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag == 1) {
            tail.next = new ListNode(1);
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
