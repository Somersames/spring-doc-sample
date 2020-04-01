package xyz.somersames.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xyz.somersames.AsyncApplication;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AsyncApplication.class)
@WebAppConfiguration
//@EnableAsync(proxyTargetClass = true)
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class TestServiceTest {


    @Autowired
    TestService testService;

    @Test
    public void noReturnAsync() throws InterruptedException, ExecutionException {
        testService.noReturnAsync();
        Thread.currentThread().sleep(2000);
    }
}