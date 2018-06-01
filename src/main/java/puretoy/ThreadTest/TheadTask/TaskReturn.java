package puretoy.ThreadTest.TheadTask;

/**
 * Created by kingb on 2018/5/31.
 */
public class TaskReturn {
    public void doReturn(){
        System.out.println("任务A，B，C均执行完毕，最后结果合成");
        return;
    }
}
