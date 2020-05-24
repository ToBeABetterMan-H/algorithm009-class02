package com.wxh.algorithm;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串

class IsPalindrome {

    /**
     * 1. 双指针
     * 2. 过滤干扰符号
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++; right--;
        }
        return true;
    }
}
