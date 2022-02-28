package leetcode.editor.cn;//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 105] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1265 👎 0


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
class Solution234 {

    public static void main(String[] args) {

        int[] arr = {1,2,2,1};
        ListNode test = new ListNode(arr);
        Solution234 solution = new Solution234();

        boolean palindrome = solution.isPalindrome(test);

        System.out.println(palindrome);

    }

    // 解法一
    // public boolean isPalindrome(ListNode head) {
    //     ListNode flag = head;
    //     Stack<Integer> stack = new Stack<>();
    //     while (head != null) {
    //         stack.push(head.val);
    //         head = head.next;
    //     }
    //     while (!stack.isEmpty()) {
    //         if (stack.pop() != flag.val) {
    //             return false;
    //         }
    //         flag = flag.next;
    //     }
    //     return true;
    // }
    
    // 解法二
    // public boolean isPalindrome(ListNode head) {
    //     ListNode flag1 = head, flag2 = head;
    //
    //     while (head.next != null) {
    //         head = head.next;
    //     }
    //
    //     while (flag1 != head) {
    //         ListNode node = new ListNode(flag1.val);
    //         ListNode flag = head.next;
    //         head.next = node;
    //         node.next = flag;
    //         flag1 = flag1.next;
    //     }
    //
    //     while (flag2 != head) {
    //         if (flag2.val != flag1.val) {
    //             return false;
    //         }
    //         flag1 = flag1.next;
    //         flag2 = flag2.next;
    //     }
    //
    //     return true;
    // }
    
    // 解法3
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
    
}
//leetcode submit region end(Prohibit modification and deletion)
