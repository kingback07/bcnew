package puretoy.ThreadTest.TheadTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kingb on 2018/5/31.
 *
 */
public abstract class AbstractTaskQuery implements ITaskforQueryInfo {

    abstract void doQuery() throws InterruptedException;

    private CountDownLatch latch;

    public void setLatch(CountDownLatch lat){
        latch=lat;
    }

    public void run() {
        try {
            this.doQuery();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
