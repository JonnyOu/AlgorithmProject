package leetcode.editor.cn;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2300 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        ListNode test = new ListNode(arr);

        ListNode node = new Solution206().reverseList(test);
        System.out.println(node);
    }
    
    public ListNode reverseList(ListNode head) {
        
        // 法一：迭代
        // ListNode it = null;
        // while (head != null) {
        //     ListNode node = head.next;
        //     head.next = it;
        //     it = head;
        //     head = node;
        // }
        // return it;

        // 法二：递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)
