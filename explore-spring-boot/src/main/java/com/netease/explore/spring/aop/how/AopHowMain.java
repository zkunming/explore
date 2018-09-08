package com.netease.explore.spring.aop.how;

import com.netease.explore.spring.util.MockUtil;
import java.lang.reflect.Proxy;

public class AopHowMain {

  public static void main(String[] args) throws ClassNotFoundException {

    Class<?> aClass = Class
        .forName(AopHow.class.getName(), false, AopHowMain.class.getClassLoader());

    //1、创建需要被代理的接口
    Class[] proxyInterface = new Class[]{AopHow.class};
    //2、创建被代理接口的实现
    AopHow aopHow = new AopHowImp();
    //3、创建动态代理处理器
    LogInvocationHandler logInvocationHandler = new LogInvocationHandler(aopHow);
    //4、创建动态代理实现类
    AopHow aopHowDynamicProxy = (AopHow) Proxy
        .newProxyInstance(AopHowMain.class.getClassLoader(), proxyInterface, logInvocationHandler);

    //5、开始
    aopHowDynamicProxy.how(MockUtil.getMockUser());
    aopHowDynamicProxy.helloWord("三碗猪脚");
  }
}
