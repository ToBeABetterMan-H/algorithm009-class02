package com.wxh.algorithm;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划

/**
 * 分析：
 *     1. 暴力解：是否可以列出所有的情况
 *         1 2 3 5 8 13 ...
 *     2. 找出最小重复单元：
 *         n = 1:1 -> 只能爬1阶
 *         n = 2:2 -> 从0爬2阶上来、从1爬1阶上来
 *         n = 3:3 -> 从1爬2阶上来、从2爬1阶上来
 *         ==> n = 4: 从2爬2阶上来、从3爬1阶上来
 *         ==> Fn = F(n-1) + F(n-2)
 */
public class ClimbStairs_70 {

    /** 最优解 */
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

    public int climbStairs2(int n) {
        int prev2 = 1;
        int prev1 = 2;
        int result = n;
        for (int i = 3; i <= n; i++) {
            result = prev1 + prev2;
            prev2 = prev1;
            prev1 = result;
        }
        return result;
    }
}
