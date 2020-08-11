package test;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 21:06
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public static class SingletonHolder {

        private static Singleton singleton = new Singleton();
    }
}
