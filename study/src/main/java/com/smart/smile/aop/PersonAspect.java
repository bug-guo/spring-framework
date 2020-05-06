package com.smart.smile.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect        // 不能作为bean的识别注解
@Component
public class PersonAspect {
	@Pointcut(value = "execution(* com.smart.smile.aop.Person.*(..))")
	public void pointcut1() {
	}

	/**
	 * 指定连接点匹配的类型或所在位置
	 */
	@Pointcut("within(com.smart.smile.aop.*)")
//	@Pointcut("within(com.smart.smile.aop.Person)")
	private void pointcut2() {
	}

	/**
	 * 匹配带有@Scope注解的类，该注解只能放在该类的头部，不能在配置中生成时使用否则无效
	 *
	 * @Bean
	 * @Scope(DefaultListableBeanFactory.SCOPE_PROTOTYPE) public Person person() {
	 * return new Person("zhangsan", 20);
	 * }
	 */
	@Pointcut("@within(org.springframework.context.annotation.Scope)")
	private void pointcut3() {
	}

	/**
	 * 和@within的效果相同
	 */
	@Pointcut("@target(org.springframework.context.annotation.Scope)")
	private void pointcut4() {
	}

	/**
	 * 指定目标对象是某种类型以及子类的实例对象
	 */
	@Pointcut("target(com.smart.smile.aop.Person)")
	private void pointcut5() {
	}

	//	@Before("pointcut1() && pointcut2()")
//	@Before("execution(* com.smart.smile.aop.Person.*(..))")
//	@Before("pointcut2() && pointcut3()")
//	@Before("pointcut1() && pointcut5()")
	@Before("pointcut1()")
	public void before() {
		System.out.println("before advice");
//		throw new InterruptedException("ss");
	}

	@Around("pointcut1()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知前");
		Object proceed = joinPoint.proceed();
		System.out.println("环绕通知后");
		return proceed;
	}

	@After("pointcut1()")
	public void after() {
		System.out.println("后置通知");
	}

	@AfterReturning(
			pointcut = "pointcut1()",
			returning = "retVal")
	public void afterReturing(Object retVal) {
		System.out.println("返回通知");
	}

	@AfterThrowing(
			pointcut = "pointcut1()",
			throwing = "ex"
	)
	public void afterThrowing(InterruptedException ex) {
		System.out.println("异常通知");
	}
}
