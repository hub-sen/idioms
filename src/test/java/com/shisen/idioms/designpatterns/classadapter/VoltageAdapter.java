package com.shisen.idioms.designpatterns.classadapter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/17 19:59
 * </pre>
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {



    @Override
    public int output5V() {

        int srcV = output220V();

        int desV = srcV /44;
        System.out.println("转换后 = " + desV);

        return desV;
    }
}
