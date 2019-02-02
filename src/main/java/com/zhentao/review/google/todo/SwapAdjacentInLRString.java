package com.zhentao.review.google.todo;

/**
 * <b>777. Swap Adjacent in LR String</b>
 * 
 * <pre>
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(final String start, final String end) {
        return false;
    }
}
