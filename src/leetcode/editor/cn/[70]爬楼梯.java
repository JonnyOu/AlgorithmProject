package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(4));
    }
    
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int x = 1, y = 2;
        for (int i = 3; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return x+y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
