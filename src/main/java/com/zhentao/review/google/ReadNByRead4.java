package com.zhentao.review.google;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>157. Read N Characters Given Read4</b>
 * <pre>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.
 * </pre> 
 * @author zhentao
 *
 */
public class ReadNByRead4 {

    public int read4(char[] buffer) {
        return ThreadLocalRandom.current().nextInt(5);
    }
    
    public int read(char[] buffer, int n) {
        int count = 0;
        while (count + 4 <= n) {
            char[] temp = new char[4];
            int read = read4(temp);
            System.arraycopy(temp, 0, buffer, count, read);
            count += read;
            if (read < 4) {
                return count;
            }
        }
        int left = n- count;
        if (left != 0) {
            char[] temp = new char[4];
            int read = read4(temp);
            int min = Math.min(left, read);
            System.arraycopy(temp, 0, buffer, count, min);
            count += min;
        }
        return count;
    }
}
