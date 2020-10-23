package com.zhentao.review.facebook;

import java.util.Stack;

/**
 * <b>71. Simplify Path</b>
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 *
 * <pre>
Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:

Input: "/a/./b/../../c/"
Output: "/c"

Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0071 {
    public static void main(String[] args) {
        LeetCode0071 lc = new LeetCode0071();
        System.out.println(lc.simplifyPathSplit("/a//b////c/d//././/.."));
        System.out.println(lc.simplifyPathSplit("/a/../../b/../c//.//"));
        System.out.println(lc.simplifyPathSplit("/a/./bc/../../c/"));
        System.out.println(lc.simplifyPathSplit("/home//foo/"));
        System.out.println(lc.simplifyPathSplit("/../"));
        System.out.println(lc.simplifyPathSplit("/..."));
        System.out.println(lc.simplifyPathSplit("/..hidden.."));
    }

    public String simplifyPathSplit(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (dir.equals(".") || dir.equals("")){
                //do nothing
            } else {
                stack.push(dir);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String dir : stack) {
            builder.append("/").append(dir);
        }
        if (builder.length() == 0) {
            builder.append("/");
        }
        return builder.toString();
    }


    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder("/");

        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '.') {
                if (builder.charAt(builder.length()-1) != '/') {
                    builder.append('.');
                } else {
                    if (isSingleDot(i+1, path)) {
                        //do nothing
                    } else if (isDoubleDots(i+1, path)) {
                        moveToUpLevel(builder);
                        i++;
                    } else {
                        builder.append('.');
                    }
                }
            } else if (ch == '/') {
                if (builder.charAt(builder.length()-1) != '/') {
                    builder.append(ch);
                }
            } else {
                builder.append(ch);
            }
        }
        //remove trailing slash /
        while(builder.length()!=1 && builder.charAt(builder.length()-1) == '/') {
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.toString();
    }

    private boolean isSingleDot(int index, String path) {
        return index == path.length() || path.charAt(index) == '/';
    }

    private boolean isDoubleDots(int index, String path) {
        if (index == path.length() - 1 && path.charAt(index) == '.') {
            return true;
        }
        if (index < path.length() - 1 && path.charAt(index) == '.' && path.charAt(index+1)=='/') {
            return true;
        }
        return false;
    }

    private void moveToUpLevel(StringBuilder builder) {
        if (builder.length() != 1) {
            builder.deleteCharAt(builder.length()-1);
            while(builder.charAt(builder.length()-1) != '/') {
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }


}
