package xyz.somersames.anno.register;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void springBeanPointcut() {
    }

    @Pointcut("within(xyz.somersames.*.controller..*)")
    public void requestServer() {
    }

    @Around("requestServer() && springBeanPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start---" + System.currentTimeMillis());
        Object resp = pjp.proceed();
        System.out.println("end---" + System.currentTimeMillis());
        return resp;
    }
}
