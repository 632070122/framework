package aop.anno.utils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect //当前类是一个切面类
public class Logger {

    @Pointcut("execution(* aop.anno.service.impl.*.*(..))")
    private void pt(){}

    @Before("pt()")
    public void beforePrintLog() {
        System.out.println("前置通知");
    }

    @AfterReturning("pt()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知");
    }

    @AfterThrowing("pt()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知");
    }

    @After("pt()")
    public void afterPrintLog() {
        System.out.println("最终通知");
    }




   /* @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();  //得到方法运行所需要的参数
            System.out.println("此处是前置通知");
            rtValue = pjp.proceed(args);// 明确调用业务层方法,切入点方法
            System.out.println("此处是后置通知");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("此处是异常通知");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("此处是最终通知");
        }
    }*/

}
