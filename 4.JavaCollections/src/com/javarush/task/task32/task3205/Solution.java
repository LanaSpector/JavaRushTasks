package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/* 
Создание прокси-объекта
*/

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();

        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods someObj = new SomeInterfaceWithMethodsImpl();
        ClassLoader classLoader = someObj.getClass().getClassLoader();
        Class[] interfaces = someObj.getClass().getInterfaces();
        SomeInterfaceWithMethods proxySome = (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, new CustomInvocationHandler(someObj));
        return proxySome;
    }
}
