package puretoy.ThreadTest.SynchronizedTest;

/**
 * Created by kingb on 2018/7/4.
 *
 * 对多线程场景下的共享资源排他锁进行测试：
 * 被synchronized修饰的方法或者是实体在多线程场景中如果遇到非synchronized方法描述的共享变量修改时，是否能够保证
 * 变量的线程安全
 * 实验证明：Synchronized和ReentrantLock互斥的相同对象下被S/L修饰的代码块，那么改对象下如果存在非同步代码块中对属性的操作，则即使
 * 属性存在于同步代码块中，依然线程不安全！！！
 * volatile关键字用于修饰属性，保证属性值的可见性。
 */
public class ResultMain {

    public static void main(String[] args) throws InterruptedException {
        DemoData dt=new DemoData();


        Thread4NonSyncSetValue nonth=new Thread4NonSyncSetValue(dt);
        Thread4SyncSetValue syncth=new Thread4SyncSetValue(dt);

        Thread th1=new Thread(nonth);
        Thread th2=new Thread(syncth);
        long staTimeStmp=System.currentTimeMillis();
        th2.start();
        Thread.sleep(3000);
        th1.start();
        System.out.println("阻塞等待...");
        while (!dt.getOutSwitch()){
            Thread.sleep(10);
            System.out.print(".");
        }
        long endTimeStmp=System.currentTimeMillis();
        System.out.println("共阻塞用时："+(endTimeStmp-staTimeStmp));
        dt.getTokenStr();
    }



}
