package com.zhentao.review.cracking;

/** <b>1.6 String Compression</b>
 * <pre>
 * String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * </pre>
 * @author zhentao.li
 *
 */
public class StringCompression {
	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}
	public static String compress(String s) {
		int length = s.length();
		if (length == 0) {
			return s;
		}
		StringBuilder builder = new StringBuilder().append(s.charAt(0));
		int count = 1;
		for (int i = 1; i < length; i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				count++;
			} else {
				builder.append(count);
				builder.append(s.charAt(i));
				count = 1;
			}
		}
		builder.append(count);
		if (builder.length() >= length) {
			return s;
		} else {
			return builder.toString();
		}
	}
}
