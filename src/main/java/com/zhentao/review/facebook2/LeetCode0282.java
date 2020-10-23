package com.zhentao.review.facebook2;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>282. Expression Add Operators</b> Hard
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 *
 * <pre>
Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]

Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:

Input: num = "3456237490", target = 9191
Output: []

Constraints:

    0 <= num.length <= 10
    num only contain digits.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0282 {
    public static void main(String[] args) {
        LeetCode0282 lc = new LeetCode0282();
        System.out.println(lc.addOperators("1023", 6));
    }

    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0)
            return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }
        // start from first index of current position in num string, try all possible
        // length of nums
        for (int i = pos; i < num.length(); i++) {
            // corner case: if current position is 0, we can only use it as a single digit
            // number as 0
            // if it is not a single digit number with leading 0, it should be considered as
            // an invalid number
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            // position 0 should be considered individually, since it does not have any
            // operand before curNum
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
