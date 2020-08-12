package com.shisen.aobing.enumtest;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/15 15:18
 * </pre>
 */
public class SingletonObject {

    private SingletonObject(){

    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject instance = new SingletonObject();

        private SingletonObject getInstance(){
            return instance;
        }

    }

    public static SingletonObject getInstance(){
        return Singleton.INSTANCE.getInstance();
    }


}
