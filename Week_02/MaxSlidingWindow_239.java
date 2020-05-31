package com.wxh.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 *
 * 提示：
 *`
 *     1 <= nums.length <= 10^5
 *     -10^4 <= nums[i] <= 10^4
 *     1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 2020-05-26 21:05:09
 */
public class MaxSlidingWindow_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.poll();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }

    /** Best solution
     * 1. 找出初始窗口中的最大值max-maxIdx
     * 2. 每挪动一次，就比较新值与最大值。新值大于等于max，则max = 新值
     * 3. 当maxIdx不在窗口内时，重新查找窗口内的最大值
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < nums.length - k + 1; idx++) {
            if (maxIdx >= idx) {
                if (max <= nums[idx + k - 1]) {
                    max = nums[idx + k - 1];
                    maxIdx = idx + k - 1;
                }
            } else {
                max = nums[idx];
                for (int i = idx + 1; i < idx + k; i++) {
                    if (max < nums[i]) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }
            }
            ans[idx] = max;
        }
        return ans;
    }
}
