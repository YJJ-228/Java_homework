package Testing.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Mythread {
    private static final int CORE_POOL_SIZE = 5;    //核心线程数
    private static final int MAX_POOL_SIZE = 10;    //最大线程数
    private static final int QUEUE_CAPACITY = 100;  //队列容量
    private static final Long KEEP_ALIVE_TIME = 1L; //保活时间

    public static void main(String[] args) {
        try (ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY),new ThreadPoolExecutor.CallerRunsPolicy())) {
            for (String url : new URLstore().urlstoring())
            {
                Runnable worker=new MyRunnable(url);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }//等线程结束再结束运行
        }
        System.out.println("Finished all threads");
    }

}

class URLstore
{//这个写法非线程安全，最好一个个加入到线程池中
    public ArrayList<String> urlstoring(){
        ArrayList<String> urls = new ArrayList<>(Arrays.asList(
        "https://blog.alistofyjj.top/img/loading.gif",
        "https://blog.alistofyjj.top/img/prepare.png",
        "https://blog.alistofyjj.top/img/jiangzhexin.png",
        "https://blog.alistofyjj.top/img/default.jpg"));
        return urls;
    }
}


