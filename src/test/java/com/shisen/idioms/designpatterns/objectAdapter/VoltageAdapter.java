package com.shisen.idioms.designpatterns.objectAdapter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/17 20:11
 * </pre>
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;



    public VoltageAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }


    @Override
    public int output5V() {
        int serV = voltage220V.output220V();

        int desV = serV / 44;

        return desV;
    }
}
