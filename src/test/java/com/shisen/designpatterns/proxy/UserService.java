package com.shisen.designpatterns.proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:52
 * </pre>
 */
public class UserService implements IUserService{
    @Override
    public void insert(String name) {
        System.out.println(String.format("用户[name: %s]插入成功", name));
    }
}
