package puretoy.ThreadTest.SynchronizedTest;

/**
 * Created by kingb on 2018/7/4.
 */
public class Thread4SyncSetValue implements Runnable {
    private DemoData dataSource;
    public Thread4SyncSetValue(DemoData dt){
        dataSource=dt;
    }

    public void run() {
        try {
            System.out.println("执行同步更新线程------------");
            dataSource.syncSetToken();
            dataSource.getTokenStr();
            System.out.println("同步更新线程结束------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
