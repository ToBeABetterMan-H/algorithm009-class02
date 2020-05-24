package com.wxh.algorithm;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例：
//
// 输入：[1,8,6,2,5,4,8,3,7]
// 输出：49
// Related Topics 数组 双指针

/**
 * V = (x2 - x1) * min(y1,y2)
 * 1. 双重for循环，找出最大的乘积 时间复杂度O(n ^2) 空间复杂度O(1)
 * 2. 双指针，移动短板 时间复杂度O(n) 空间复杂度O(1)
 * 2020-05-19 07:24:43
 */
public class MaxArea_11 {
    /** 双循环暴力解 */
    public int maxArea(int[] height) {
        int v = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tmp = (j - i) * Math.min(height[i], height[j]);
                if (tmp > v)  v = tmp;
            }
        }
        return v;
    }

    /** 最优解
     * 问题的关键在于理解消除不可能的情况
     */
    public int maxArea2(int[] height) {
        int v = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            v = height[i] < height[j] ?
                    Math.max(v,(j - i) * height[i++]) :
                    Math.max(v,(j - i) * height[j--]);
        }
        return v;
    }

    public int maxArea3(int[] height) {
        int v = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            v = Math.max(v, (j - i + 1) * minHeight);
        }
        return v;
    }
}
