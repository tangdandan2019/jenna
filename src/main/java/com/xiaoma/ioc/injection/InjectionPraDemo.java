package com.xiaoma.ioc.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Tang dandan
 * @Date: 2020/1/29 12:57
 */
public class InjectionPraDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动xml上下文
        BeanFactory  beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection.xml");
    }
}
