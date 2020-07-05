package github.compatibility.source;

import github.compatibility.source.inteface.DefaultInterfaceImpl;
import github.compatibility.source.inteface.PublicIntefaceImpl;
import github.compatibility.source.inteface.PulicInteface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author elseifer
 * @version $Id: SourceCompatibilityDemo.java, v 0.1 2020年06月28日 下午4:19 elseifer Exp $
 */
public class SourceCompatibilityDemo {

    public static void main(String[] args) throws Exception {

        ClassLoader cl = SourceCompatibilityDemo.class.getClassLoader();

        SourceCompatibilityDemo sc = new SourceCompatibilityDemo();

        sc.demoPublic(cl);

        sc.demoDefault(cl);

    }

    public void demoPublic(ClassLoader cl) throws Exception {

        final PulicInteface pulicInteface = new PublicIntefaceImpl();

        Class proxyClass = Proxy.getProxyClass(cl, pulicInteface.getClass().getInterfaces());

        // proxy 类自带一个包含 InvocationHandler 参数的构造器
        Constructor<PulicInteface> constructor = proxyClass.getDeclaredConstructor(InvocationHandler.class);

        constructor.setAccessible(true);

        PulicInteface instanceProxy = constructor.newInstance(new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method,
                                 Object[] args) throws Throwable {

                System.out.print("hello, ");

                return method.invoke(pulicInteface, args);
            }

        });

        instanceProxy.method();

    }

    public void demoDefault(ClassLoader cl) throws Exception {

        final DefaultInterfaceImpl defaultInterface = new DefaultInterfaceImpl();

        Class proxyClass = Proxy.getProxyClass(cl, defaultInterface.getClass().getInterfaces());

        // proxy 类自带一个包含 InvocationHandler 参数的构造器
        Constructor constructor = proxyClass.getDeclaredConstructor(InvocationHandler.class);

        //JDK 8 需要
        constructor.setAccessible(true);

        Object instanceProxy = constructor.newInstance(new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method,
                                 Object[] args) throws Throwable {

                System.out.print("hello, ");

                method.setAccessible(true);

                return method.invoke(defaultInterface, args);
            }

        });

        Method method = proxyClass.getMethod("method",null );

        //JDK 8 需要
        //method.setAccessible(true);

        method.invoke(instanceProxy,null);

    }

}