package com.zhentao.review.google;

/**
 * <b>158. Read N Characters Given Read4 II - Call multiple times</b>
 * 
 * <pre>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
 * </pre>
 * 
 * @author zhentao
 *
 */
public abstract class ReadNByRead4Multiple {
    public abstract int read4(char[] buffer);

    private char[] buf4;;
    private int currentIndex;
    private int size;

    public ReadNByRead4Multiple() {
        buf4 = new char[4];
        currentIndex = 0;
        size = 0;
    }

    public int read(char[] buff, int n) {
        int count = 0;
        for (; count < size - currentIndex; count++) {
            buff[count] = buf4[currentIndex + count];
        }

        currentIndex = 0;
        size = 0;
        while (count < n) {
            size = read4(buf4);
            if (size < 4) {
                if (count + size <= n) {
                    System.arraycopy(buf4, 0, buff, count, size);
                    return count + size;
                } else {
                    System.arraycopy(buf4, 0, buff, count, n - count);
                    currentIndex = n - count;
                    return n;
                }
            } else if (count + size <= n) {
                System.arraycopy(buf4, 0, buff, count, size);
                count += size;
                size = 0;
            } else {
                System.arraycopy(buf4, 0, buff, count, n - count);
                currentIndex = n - count;
                return n;
            }
        }
        return count;
    }
}
