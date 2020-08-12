package com.shisen.aobing.threadlocal;

import java.text.SimpleDateFormat;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 10:55
 * </pre>
 */
public class DateFormatUtils {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}
