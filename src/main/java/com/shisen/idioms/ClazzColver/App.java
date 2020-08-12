package com.shisen.idioms.ClazzColver;

import java.util.Date;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/5/24 17:18
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.setDate(new Date());
        test1.setDate1(new Date());


        Test2 test2 = ClazzConverter.converterClass(test1, Test2.class);



        //test2.setDateStr("hello");

        System.out.println("test2 = " + test2);



        System.out.println("(2.4+12)/24 = " + (int)((16+12.0)/24));
    }
}
