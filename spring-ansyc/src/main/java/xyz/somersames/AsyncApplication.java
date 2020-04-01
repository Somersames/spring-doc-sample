package xyz.somersames;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author sunzhaohui
 */
@SpringBootApplication
@EnableAsync
//@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class AsyncApplication {
}
