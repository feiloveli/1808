/** 
 * <pre>项目名称:power 
 * 文件名称:LogAspect.java 
 * 包名:com.jk.aspect 
 * 创建日期:2018年12月26日上午9:47:33 
 * Copyright (c) 2018, wzstart@126.com All Rights Reserved.</pre> 
 */
package com.jk.aspect;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jk.bean.Log;
import com.jk.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jk.util.CusAccessObjectUtil;

/**
 * 业精于勤荒于嬉,行成于思毁于随 创建人：wzstart 创建时间：2018年12月26日 上午9:47:33
 * 
 * 切面类
 * 
 * 在controller里面进行保存日志 不合适
 * 
 * 1.保存日志的代码每个方法里面都要写,并且代码还相同 造成代码的冗余
 * 
 * 2.业务代码和非业务代码全挤在一起 耦合度高
 */
@Aspect // 标示这是一个切面类
@Component // 交给spring进行管理
public class LogAspect {

	@Autowired
	MongoTemplate mongoTemplate;
	// 切面=切入点+通知
	// 要拦截指定的方法 给方法增加一些功能 通过切入点找到指定方法
	 /**
     * 定义一个切入点表达式,用来确定哪些类需要代理
     * @Pointcut("execution(* com.jk.service.impl.*.*(..))")代表com.jk.service包下所有类的所有方法都会被代理
     */
	@Pointcut("execution( * com.jk.service.impl.LoginServiceImpl.*(..))")
	public void pointCut() {// 定义一个切入点

	}

	// 通知 给连接点的方法增强功能
	 /**
     * 前置方法,在目标方法执行前执行
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
	@Before(value = "pointCut()") // 给ServiceImpl 下面所有的方法 执行前增加功能
	public void test(JoinPoint joinPoint) {//在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象. 
           
		    System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
		    System.out.println("前置通知:目标方法名为:" + joinPoint.getSignature().getName());
	       // System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
	       // System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
    }
	
    //后置通知
	@After(value = "pointCut()")
	public void testAfter(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
	    System.out.println("目标方法所属类的简单类名:" + className);
		System.out.println("后置通知:访问"+className+"类的" + joinPoint.getSignature().getName() + "方法执行了.....");
	}
	
	
	//returning = "rtv"   获取目标方法返回值
	@AfterReturning(value = "pointCut()", returning = "rtv")
	public void testAfterRun(JoinPoint joinPoint, User rtv) {
		// 在这里进行保存日志
		
		//类名
		String className = joinPoint.getTarget().getClass().getSimpleName();
       
		//方法名
		String method = joinPoint.getSignature().getName();
        if(method.equals("queryUserByNameAndPswd")){
        	method="登录日志";
        	if(rtv!=null){
				log(joinPoint, "账号为:'"+rtv.getLoginacct()+"'用户为:'"+rtv.getUsername()+"',登陆成功!", method);

			}else{
				log(joinPoint, "用户名或者密码错误", method);
			}
        }
        if(method.equals("register")){	
        	method="注册日志";
        	if(rtv.toString().equals("1")){

				log(joinPoint, "注册成功", method);
			}else{
				log(joinPoint, "注册失败", method);
			}

        }


	}

	private void log(JoinPoint joinPoint, String rtv, String method) {
		//joinpoint.getargs():获取带参方法的参数
		Object[] args = joinPoint.getArgs();

		String str = "{";
		for (Object object : args) {
			str += object + ",";
		}
		str += "}";
		System.out.println("....获取传入目标方法的请求参数 ====>  " + str);


		//在切面类中 获取 servletRequestAttributes对象:
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		User user = null;
		String url = "未初始化";
		String ipAddress="未初始化IP";

		//session对象为空说明用户还没有登陆
		if (servletRequestAttributes == null) {

			System.out.println("空的 谨慎操作");

		} else { //说明已经登录
			 //在切面类中 通过 servletRequestAttributes对象     获取:Request对象
			HttpServletRequest request = servletRequestAttributes.getRequest();
			HttpSession session = request.getSession();

			url=request.getRequestURL().toString();
			user = (User) session.getAttribute("user");
			//request.getHeader :
			String Referer = request.getHeader("Referer");
			//请求头的信息 在页面按 f12 可以看
			//获取
			String Agent = request.getHeader("User-Agent");
			System.out.println( Referer +" ===  "+ Agent);

			ipAddress = CusAccessObjectUtil.getIpAddress(request);

		}
		/*String newrvf="";
		if(rtv.equals("1")){
			newrvf="登录失败,用户名或密码错误";

		} else if(rtv.equals("3")) {
			newrvf="登录失败,验证码错误";
		} else if(rtv.equals("2")){
			newrvf="登录成功";
		}*/
		Log log = new Log( method, new Date(), rtv);
		mongoTemplate.save(log);
	}

	/**
	 * <pre>
	 * afterThrowing(这里用一句话描述这个方法的作用)   
	 * 创建人：wzstart  
	 * 业精于勤荒于嬉,行成于思毁于随
	 * 创建时间：2018年12月26日 下午12:54:37     
	 * &#64;param joinPoint
	 * </pre>
	 * 
	 * 连接点方法抛出异常后会执行此方法
	 **/
	@AfterThrowing(value = "pointCut()")
	public void afterThrowing(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();

		String method = joinPoint.getSignature().getName();
		Log log = new Log();
		log.setLogname(method);
		log.setLogdate(new Date());
		log.setLognodes("报错了 快去看看吧");

		mongoTemplate.save(log);
	}

}
