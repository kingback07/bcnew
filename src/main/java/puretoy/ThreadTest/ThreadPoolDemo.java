package puretoy.ThreadTest;

import puretoy.ThreadTest.TheadTask.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kingb on 2018/5/31.
 * 使用固定线程池 FixedThreadPool+CountDownLatch来执行多线程和控制结果同步
 * Tips：
 *
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        long staTime=System.currentTimeMillis();
        //模拟登陆验证
        TaskLogin login=new TaskLogin();
        login.verifyLogin();
        //对验证成功的结果开启线程池，支持3个查询任务
        ExecutorService ec= Executors.newFixedThreadPool(3);
        CountDownLatch latch=new CountDownLatch(3);//设置倒计时器，控制3个流程走完继续下一步
        ec.submit(new TaskQueryA(latch));
        ec.submit(new TaskQueryB(latch));
        ec.submit(new TaskQueryC(latch));
        //阻塞，等待任务完成继续
        latch.await();
        TaskReturn tres =new TaskReturn();
        tres.doReturn();
        long endTime=System.currentTimeMillis();
        System.out.println("流程执行结束，共耗时："+(endTime-staTime)/1000);
    }



}
