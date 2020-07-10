import java.util.Arrays;

/**
 * DESCRIPTION:
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxh
 * @date 2020/7/10 20:55
 */
public class RelativeSortArray_1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001]; // 0 <= arr1[i], arr2[i] <= 1000
        int[] res = new int[arr1.length];
        int idx = 0;

        for (int n : arr1) arr[n]++; // 统计各个值出现的次数
        for (int n : arr2) while (arr[n]-- > 0) res[idx++] = n;
        for (int i = 0; i < 1001; i++) while (arr[i]-- > 0) res[idx++] = i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
