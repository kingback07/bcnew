package puretoy;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class mytoy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		ThreadCall tc = new ThreadCall();
		tc.setCount(count);
		tc.setLoopNum(10000000);

		/**
		 * 采用线程池执行多线程操作
		 */

		ThreadPoolExecutor excutor = new ThreadPoolExecutor(1, 10, 200, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(5));
		long startTime = new Date().getTime();
		for (int i = 0; i <= 2; i++) {
			RunThread rt = new RunThread(tc);
			rt.setRunIndex(i+1);
			excutor.execute(rt);
			System.out.println("线程池中线程数目：" + excutor.getPoolSize() + "，队列中等待执行的任务数目：" + excutor.getQueue().size()
					+ "，已执行完别的任务数目：" + excutor.getCompletedTaskCount());
		}
		excutor.shutdown();
		while (!excutor.isTerminated()) {

		}
		long endTime = new Date().getTime();
		System.out.println("多线程运行结束，共耗时：" + (endTime - startTime) + "ms");

		/**
		 * 手动创建线程
		 */
//		long startTime = new Date().getTime();
//		RunThread rt1 = new RunThread(tc);
//		rt1.setRunIndex(1);
//		RunThread rt2 = new RunThread(tc);
//		rt2.setRunIndex(2);
//		Thread th1 = new Thread(rt1);
//		th1.start();
//		Thread th2 = new Thread(rt2);
//		th2.start();
//		while (th1.isAlive() || th2.isAlive()) {
//
//		}
//		long endTime = new Date().getTime();
//		System.out.println("多线程运行结束，共耗时：" + (endTime - startTime) + "ms");

	}

}
