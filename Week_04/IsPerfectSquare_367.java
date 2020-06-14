package com.wxh.algorithm.week04;

/**
 * @DESCRIPTION:
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @USER: wxh
 * @DATE: 2020/6/13 22:17
 */

public class IsPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int i = 1;
        int tmp = i * i;
        while (tmp <= num) {
            if (tmp == num) return true;
            i++;
            tmp = i * i;
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int tmp = 1;
        while (num > 0) {
            num -= tmp;
            tmp += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare3(int num) {
        int low = 1, height = num;
        while (low <= height) {
            long mid = (low + height) >>> 1;
            long tmp = mid * mid;
            if (tmp == num) return true;
            else if (tmp < num) low = (int)mid + 1;
            else height = (int)mid - 1;
        }
        return false;
    }
}
