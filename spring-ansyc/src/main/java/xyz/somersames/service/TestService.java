package xyz.somersames.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class TestService {

    @Autowired
    AsyncService asyncService;

    public void noReturnAsync() throws InterruptedException, ExecutionException {
        Future future = asyncService.futureA();
        asyncService.sayB();
        asyncService.sayA();
        System.out.println(future.get());
        ((TestService) AopContext.currentProxy()).C();
    }

    @Async("asyncPool")
    public void C(){
        System.out.println("C");
    }
}
