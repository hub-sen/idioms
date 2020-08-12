package com.shisen.idioms.designpatterns.objectAdapter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/17 20:12
 * </pre>
 */
public class Phone {
    public void charging(IVoltage5V iVoltage5V){
        int i = iVoltage5V.output5V();
        System.out.println("i = " + i);

    }

    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
