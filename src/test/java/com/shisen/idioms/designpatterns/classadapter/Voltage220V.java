package com.shisen.idioms.designpatterns.classadapter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/17 19:56
 * </pre>
 */
public class Voltage220V {

    public int output220V(){
        int srcV = 220;

        System.out.println("srcV = " + srcV);

        return srcV;

    }

}
