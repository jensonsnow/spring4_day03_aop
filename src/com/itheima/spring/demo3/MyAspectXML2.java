package com.itheima.spring.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectXML2 {
	
	/*
	 * 前置通知
	 * */
	@Before(value="MyAspectXML2.pointcut1()")
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("权限校验==================="+joinPoint);
	}

	/**
	 * 后置通知
	 * @param  
	 */
	@AfterReturning(value="MyAspectXML2.pointcut2()",returning="result")
	public void writeLog(Object result) {
		System.out.println("日志记录==================="+result);
	}
	
	
	/**
	 * 环绕通知   进行性能的监控
	 * @throws Throwable 
	 */
	@Around(value="MyAspectXML2.pointcut3()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕前通知===================");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("环绕后通知===================");
		return obj;
	}
	
	/**
	 * 异常抛出通知
	 */
	@AfterThrowing(value="MyAspectXML2.pointcut4()",throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("异常抛出通知==================="+ex.getMessage());
	}
	
	/**
	 * 最终通知 相当于finally代码块中的内容
	 */
	@After(value="MyAspectXML2.pointcut4()")
	public void after() {
		System.out.println("最终通知===================");
	}
	
	
	
	@Pointcut(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.save(..))")
	private void pointcut1() {}
	
	@Pointcut(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.delete(..))")
	private void pointcut2() {}
	
	@Pointcut(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.update(..))")
	private void pointcut3() {}
	
	@Pointcut(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.find(..))")
	private void pointcut4() {}
 }
