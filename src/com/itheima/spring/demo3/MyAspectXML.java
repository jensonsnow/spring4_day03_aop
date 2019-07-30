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
	 * ǰ��֪ͨ
	 * */
	@Before(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.save(..))")
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("Ȩ��У��==================="+joinPoint);
	}

	/**
	 * ����֪ͨ
	 * @param  
	 */
	@AfterReturning(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.delete(..))",returning="result")
	public void writeLog(Object result) {
		System.out.println("��־��¼==================="+result);
	}
	
	
	/**
	 * ����֪ͨ   �������ܵļ��
	 * @throws Throwable 
	 */
	@Around(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.update(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����ǰ֪ͨ===================");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("���ƺ�֪ͨ===================");
		return obj;
	}
	
	/**
	 * �쳣�׳�֪ͨ
	 */
	@AfterThrowing(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.find(..))",throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("�쳣�׳�֪ͨ==================="+ex.getMessage());
	}
	
	/**
	 * ����֪ͨ �൱��finally������е�����
	 */
	@After(value="execution(* com.itheima.spring.demo3.ProductDaoImpl.find(..))")
	public void after() {
		System.out.println("����֪ͨ===================");
	}
	
	 
 }
