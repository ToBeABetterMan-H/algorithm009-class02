package com.wxh.algorithm;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class IsAnagram_242 {
    /**
     * 用一个长度为26（26个字母）的int数组来记录字符出现的次数
     * s中每个字符出现一次，记录值+1，t中每个字符出现一次，记录值-1
     * 最后遍历 int 数组，若发现有值不为0的，则说明s,t不是字母异位词
     *
     * 若输入字符串包含 unicode 字符，只需要将 int数组换成 map即可
     */
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length())
            return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] chars = new int[26];
        for(int i = 0; i < len; i++) {
            chars[sChars[i] - 'a']++;
            chars[tChars[i] - 'a']--;
        }
        for (int v : chars) {
            if (v != 0) return false;
        }
        return true;
    }
}
