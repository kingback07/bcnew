package puretoy.ThreadTest.TheadTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kingb on 2018/5/31.
 */
public class TaskQueryC extends AbstractTaskQuery {

    public TaskQueryC(CountDownLatch lat){
        setLatch(lat);
    }

    void doQuery() throws InterruptedException {
        long staTime=System.currentTimeMillis();
        System.out.println("任务C开始执行……");
        Thread.sleep(10000);
        long endTime=System.currentTimeMillis();
        System.out.println("任务C结束,耗时:"+(endTime-staTime)/1000);
    }
}
