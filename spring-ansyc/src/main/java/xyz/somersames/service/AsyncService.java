package xyz.somersames.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class AsyncService {


    @Async("asyncPool")
    public void sayA(){
        System.out.println("A");
    }

    @Async("asyncPool")
    public void sayB() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        System.out.println("B");
    }

    @Async("asyncPool")
    public Future<String> futureA() throws InterruptedException {
        Thread.currentThread().sleep(1100);
        return new AsyncResult<String>("A");
    }

    public void simpleThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(4,5,0, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable";
            }
        };
        Future future = executor.submit(callable);
        System.out.println(future.get());
    }
}
