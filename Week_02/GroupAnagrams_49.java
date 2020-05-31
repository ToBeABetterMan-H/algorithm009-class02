package com.wxh.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 *
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 2020-05-31 16:25:37
 */
public class GroupAnagrams_49 {

    /**
     * 转换思想：将字母异位词 转换为另外一个统一的 标识。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] chars = new int[26];
            for (char c: s.toCharArray()) chars[c - 'a']++;
            StringBuilder key = new StringBuilder();
            for (int v: chars) key.append('#').append(v);
            String sKey = key.toString();
            if (!map.containsKey(sKey)) map.put(sKey, new ArrayList<>());
            map.get(sKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
