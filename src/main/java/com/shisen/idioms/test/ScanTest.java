package com.shisen.idioms.test;

import java.util.Arrays;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/4 16:54
 * </pre>
 */
public class ScanTest {

    private char[] value;

    public static final char MIN_HIGH_SURROGATE = '\uD800';

    public static final char MAX_HIGH_SURROGATE = '\uDBFF';

    public static final char MIN_LOW_SURROGATE = '\uDC00';

    public static final char MAX_LOW_SURROGATE = '\uDFFF';

    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x010000;

    public ScanTest(String value) {
        this.value = value.toCharArray();
    }

    public ScanTest(char[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);

    }










    public static void main(String[] args) {
        ScanTest hello = new ScanTest("heLlo");
        ScanTest scanTest = hello.toLowerCase();
        System.out.println("scanTest = " + scanTest);
    }

    private ScanTest toLowerCase() {

        int firstUpper;
        final int len = value.length;

        /* Now check if there are any characters that need to be changed. */
        scan:
        {
            for (firstUpper = 0; firstUpper < len; ) {
                char c = value[firstUpper];
                if ((c >= Character.MIN_HIGH_SURROGATE)
                        && (c <= Character.MAX_HIGH_SURROGATE)) {
                    int supplChar = codePointAt(firstUpper);
                    if (supplChar != Character.toLowerCase(supplChar)) {
                        break scan;
                    }
                    firstUpper += Character.charCount(supplChar);
                } else {
                    if (c != Character.toLowerCase(c)) {
                        break scan;
                    }
                    firstUpper++;
                }
            }
            return this;
        }

        for (int i = firstUpper; i < value.length; i++) {
            value[i] = Character.toLowerCase(value[i]);
        }


        return new ScanTest(value);

    }

    public int codePointAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return codePointAtImpl(value, index, value.length);
    }

    static int codePointAtImpl(char[] a, int index, int limit) {
        char c1 = a[index];
        if (isHighSurrogate(c1) && ++index < limit) {
            char c2 = a[index];
            if (isLowSurrogate(c2)) {
                return toCodePoint(c1, c2);
            }
        }
        return c1;
    }

    public static boolean isHighSurrogate(char ch) {
        // Help VM constant-fold; MAX_HIGH_SURROGATE + 1 == MIN_LOW_SURROGATE
        return ch >= MIN_HIGH_SURROGATE && ch < (MAX_HIGH_SURROGATE + 1);
    }

    public static boolean isLowSurrogate(char ch) {
        return ch >= MIN_LOW_SURROGATE && ch < (MAX_LOW_SURROGATE + 1);
    }

    public static int toCodePoint(char high, char low) {
        // Optimized form of:
        // return ((high - MIN_HIGH_SURROGATE) << 10)
        //         + (low - MIN_LOW_SURROGATE)
        //         + MIN_SUPPLEMENTARY_CODE_POINT;
        return ((high << 10) + low) + (MIN_SUPPLEMENTARY_CODE_POINT
                - (MIN_HIGH_SURROGATE << 10)
                - MIN_LOW_SURROGATE);
    }


}
