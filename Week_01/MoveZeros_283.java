package com.wxh.algorithm;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针

/**
 * 1. 删除0 -> 末尾添加0 O(n^2)
 * 2. 交换：找到第一个0，然后与后面非0的元素交换 O(n)
 * 2020-05-18 07:37:59
 */
public class MoveZeros_283 {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        // find first 0
        for (;i < nums.length; i++) {
            if (nums[i] == 0) break;
        }

        // no 0
        if (i == nums.length) return;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
                nums[j] = 0;
            }
        }
    }

    /** 最佳实践 */
    public static void moveZeroes2(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
