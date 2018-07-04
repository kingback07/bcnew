package puretoy.ThreadTest.SynchronizedTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 对多线程场景下的共享资源排他锁进行测试：
 * 被synchronized修饰的方法或者是实体在多线程场景中如果遇到非synchronized方法描述的共享变量修改时，是否能够保证
 * 变量的线程安全
 * Created by kingb on 2018/7/4.
 */
public class DemoData {

    private String tokenStr;
    private Boolean outSwitch = false;
    ReentrantLock lock = new ReentrantLock();

    public void syncSetToken() {
        try {
            lock.lock();
            Thread.sleep(5000);
            tokenStr = "reset String to synchronized";
            outSwitch = true;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void nonsyncSetToken() {
            tokenStr = "reset String to nonesynchronized";
            outSwitch = true;
    }

    public void getTokenStr() {
        System.out.println("DemoData.tokenStr=" + tokenStr);
    }

    public Boolean getOutSwitch() {
        return outSwitch;
    }
}
