package com.cgj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class DaoAspect2 {
    //切点
    @Pointcut("execution(* com.cgj.dao.UserDao.addUser(..))")
    public void pointCut() {
    }

    /**
     * 前置通知
     * 可以在前置通知的方法中添加JoinPoint参数用来获取切点对象，
     * 用切点对象来获取被增强方法参数。
     */
    @Before("pointCut()")
    public void beforeAspect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("我是前置通知 ---------- 2");
        System.out.println("前置通知获取被增强方法的参数 -- " + args + " ---------- 2");
    }

    /**
     * 后置通知
     * 无论切点是否中途出现异常都会执行，相当于finally
     */
    @After("pointCut()")
    public void afterAspect() {
        System.out.println("我是后置通知 ---------- 2");
    }

    /**
     * 返回通知
     * 接收增强方法的返回值
     * 如果增强方法中途出现了异常，就不会执行当前方法。
     */
    @AfterReturning(value = "pointCut()", returning = "res")
    public void methodAfterRuterning(JoinPoint joinPoint, Object res) {
        System.out.println("我是返回通知，增强方法的返回值是" + res + " ---------- 2");
    }


    /**
     * 异常通知
     * 切点方法出现异常时运行的增强功能
     * 如果方法运行没有出现异常,则该功能不运行 相当于 catch
     * 参数列表可以用Exception ex接收异常对象 需要通过throwing指定异常名称
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void methodAfterThrowing(Exception ex) {
        System.out.println("我是异常通知 ---------- 2");
    }

    /**
     * 环绕通知:
     * 在切点方法之前和之后都进行功能的增强
     * 需要在通知中定义方法执行的位置,并在执行位置之前和之后自定义增强的功能
     * 方法列表可以通过ProceedingJoinPoint获取执行的切点
     * 通过proceedingJoinPoint.proceed()方法控制切点方法的执行位置
     * proceedingJoinPoint.proceed()方法会将切点方法的返回值获取到,并交给我们,可以做后续处理
     * 我们在环绕通知的最后需要将切点方法的返回值继续向上返回,否则切点方法在执行时接收不到返回值
     */

    @Around("pointCut()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("前置输出 ---------- 2");
        Object res = proceedingJoinPoint.proceed();//被加强方法执行的位置
        System.out.println("后置输出 ---------- 2");
        return res;
    }
}
