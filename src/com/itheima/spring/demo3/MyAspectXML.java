package com.itheima.spring.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspectXML {
	
	/*
	 * 前置通知
	 * */
	@Before(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.save(..))")
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("权限校验==================="+joinPoint);
	}

	/**
	 * 后置通知
	 * @param  
	 */
	@AfterReturning(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.delete(..))",returning="result")
	public void writeLog(Object result) {
		System.out.println("日志记录==================="+result);
	}
	
	
	/**
	 * 环绕通知   进行性能的监控
	 * @throws Throwable 
	 */
	@Around(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.update(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕前通知===================");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("环绕后通知===================");
		return obj;
	}
	
	/**
	 * 异常抛出通知
	 */
	@AfterThrowing(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.find(..))",throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("异常抛出通知==================="+ex.getMessage());
	}
	
	/**
	 * 最终通知 相当于finally代码块中的内容
	 */
	@After(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.find(..))")
	public void after() {
		System.out.println("最终通知===================");
	}
	
	 
 }
