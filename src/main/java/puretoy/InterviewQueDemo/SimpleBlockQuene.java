package puretoy.InterviewQueDemo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建一个简单的阻塞队列
 * 消息队列：在RPC框架作为进程间通信的通道，利用阻塞消息队列方式可以控制消息的生产者线程和消费者线程的协同
 * Created by kingb on 2018/7/3.
 */
public class SimpleBlockQuene<T> {

    private final int capacity;//初始化时定义队列的阻塞阈值

    private Lock lock=new ReentrantLock();

    private Condition unFull=lock.newCondition();//生产者产生消息时达到队列阈值时阻塞

    private Condition unEmpty=lock.newCondition();//消费者消费消息时队列为空时阻塞

    private int count;//当前队列中的数量

    private LinkedList<T> quene;//实际消息队列的数据载体


    //默认阻塞上限为10
    public SimpleBlockQuene(){
        this(10);
    }

    //指定阻塞上限值的构造函数
    public SimpleBlockQuene(int cap){
        this.capacity=cap;
        quene=new LinkedList<T>();
    }


    /**
     * 控制队列的put和get方法，使用锁机制来阻塞使用 的 线程
     */

    /**
     * 获取队列中的值，如果当前队列为空则阻塞等待
     * @return
     */
    public T getValue(){
        lock.lock();
        try {
            while(count==0) unEmpty.await();
            @SuppressWarnings("Since15")
            T t=quene.pop();
            count--;//lock中保证count值是线程安全的
            unEmpty.signal();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 向队列中put值，如果队列中值满的情况下阻塞
     */
    public void setValue(T t){
        lock.lock();
        try {
            while (count==capacity) unFull.await();
            //noinspection Since15
            quene.push(t);
            count++;
            unFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
