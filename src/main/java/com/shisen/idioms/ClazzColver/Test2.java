package com.shisen.idioms.ClazzColver;

import java.util.Date;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/5/24 17:17
 * </pre>
 */
public class Test2 {
    private String dateStr;

    private Date date1;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "dateStr='" + dateStr + '\'' +
                ", date1=" + date1 +
                '}';
    }
}
