package puretoy.ThreadTest.TheadTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kingb on 2018/5/31.
 */
public class TaskQueryB extends AbstractTaskQuery {

    public TaskQueryB(CountDownLatch lat){
        setLatch(lat);
    }

    void doQuery() throws InterruptedException {
        long staTime=System.currentTimeMillis();
        System.out.println("任务B开始执行……");
        Thread.sleep(3000);
        long endTime=System.currentTimeMillis();
        System.out.println("任务B结束,耗时:"+(endTime-staTime)/1000);
    }
}
