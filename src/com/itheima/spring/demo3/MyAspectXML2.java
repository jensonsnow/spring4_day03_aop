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
	 * ǰ��֪ͨ
	 * */
	@Before(value="MyAspectXML2.pointcut1()")
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("Ȩ��У��==================="+joinPoint);
	}

	/**
	 * ����֪ͨ
	 * @param  
	 */
	@AfterReturning(value="MyAspectXML2.pointcut2()",returning="result")
	public void writeLog(Object result) {
		System.out.println("��־��¼==================="+result);
	}
	
	
	/**
	 * ����֪ͨ   �������ܵļ��
	 * @throws Throwable 
	 */
	@Around(value="MyAspectXML2.pointcut3()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����ǰ֪ͨ===================");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("���ƺ�֪ͨ===================");
		return obj;
	}
	
	/**
	 * �쳣�׳�֪ͨ
	 */
	@AfterThrowing(value="MyAspectXML2.pointcut4()",throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("�쳣�׳�֪ͨ==================="+ex.getMessage());
	}
	
	/**
	 * ����֪ͨ �൱��finally������е�����
	 */
	@After(value="MyAspectXML2.pointcut4()")
	public void after() {
		System.out.println("����֪ͨ===================");
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
