package exercises._002_longest_substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Runner {
    /**
     * Longest Substring Without Repeating Characters.
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */

    public static void main(String[] args) {
        String input = "dvdf";

        System.out.println(getLongestSubstring(input));


    }

    /**
     * Моя реализация: Brute Force
     * <p>
     * Runtime: 54 ms, faster than 16.49% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 37.1 MB, less than 99.29% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param string строка на вход
     * @return результат
     */
    static int getLongestSubstring(String string) {

        Set<Character> used = new HashSet<>();
        int longestCount = 0;
        int result = 0;

        if (string.length() == 0) return 0;

        for (int i = 0; i < string.length(); i++) {
            if ((string.length() - i) < result) {
                return result;
            }
            for (int index = i; index < string.length(); index++) {

                Character ch = string.charAt(index);
                if (!used.contains(ch)) {
                    used.add(ch);
                    longestCount++;
                } else {
                    used.clear();
                    if (longestCount > result) {
                        result = longestCount;
                    }
                    longestCount = 0;
                    break;
                }
            }
        }

        if (longestCount > result) {
            result = longestCount;
        }

        return result;
    }

    /**
     * Реализация с сайта Brute Force
     * <p>
     * <p>
     * Time Limit Exceeded!!!
     *
     * @param s
     * @return
     */
    static int getLongestSubstringBruteForce(String s) {
        int length = s.length();
        int result = 0;
        for (int start = 0; start < length; start++) {
            for (int end = start + 1; end <= length; end++) {
                if (allUnique(s, start, end)) result = Math.max(end - start, result);
            }
        }
        return result;
    }

    static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * Sliding Windows
     * <p>
     * Runtime: 10 ms, faster than 43.95% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 36.3 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    static int getLongestSubstringSlidingWindows(String s) {
        int result = 0;
        int length = s.length();
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (start < length && end < length) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }

        return result;
    }

    /**
     * Sliding Windows Optimized
     * <p>
     * Runtime: 7 ms, faster than 82.38% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 36.5 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    static int getLongestSubstringSlidingWindowsOptimized(String s) {
        int result = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < length; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return result;
    }
}
