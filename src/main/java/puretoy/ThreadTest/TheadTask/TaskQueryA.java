package puretoy.ThreadTest.TheadTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kingb on 2018/5/31.
 */
public class TaskQueryA extends AbstractTaskQuery {

    public TaskQueryA(CountDownLatch lat){
        setLatch(lat);
    }

    void doQuery() throws InterruptedException {
        long staTime=System.currentTimeMillis();
        System.out.println("任务A开始执行……");
        Thread.sleep(5000);
        long endTime=System.currentTimeMillis();
        System.out.println("任务A结束,耗时:"+(endTime-staTime)/1000);
    }
}
