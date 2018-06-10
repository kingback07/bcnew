package puretoy;

/**
 * Created by kingb on 2018/6/5.
 * 变种懒汉式的单例模式体现
 */
public class Singleton {

    //首先确保构造函数是私有的，无法外部初始化
    private Singleton(){

    }

    /**
     * 此处使用静态内部类方式定义一个对单例对象的包装类
     * 作用：使用静态内部类+饿汉式加载方式，可以保证JVM在加载此对象时
     *       遵守ClassLoader的单次加载，从而避免多线程环境下的线程安全问题
     * 此处代码在JVM启动后只会执行一次
     */
    private static class SingletonHandler{
        private static final Singleton singletonIns=new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHandler.singletonIns;
    }

}
