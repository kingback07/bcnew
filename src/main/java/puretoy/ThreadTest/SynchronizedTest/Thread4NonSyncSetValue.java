package puretoy.ThreadTest.SynchronizedTest;

/**
 * Created by kingb on 2018/7/4.
 */
public class Thread4NonSyncSetValue implements Runnable {
    private DemoData dataSource;
    public Thread4NonSyncSetValue(DemoData dt){
        dataSource=dt;
    }

    public void run() {
        System.out.println("执行非同步更新线程------------");
        dataSource.nonsyncSetToken();
        dataSource.getTokenStr();
        System.out.println("非同步更新线程结束------------");
    }
}
