package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试用例
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-08-13:30
 */
public class T4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("test.T");
        Object object = clazz.newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(object);
    }
}

class T{
    public void hello(){
        System.out.println("hello world!");
    }
}
