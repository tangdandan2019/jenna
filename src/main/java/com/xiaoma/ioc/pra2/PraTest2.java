package com.xiaoma.ioc.pra2;

import com.xiaoma.ioc.annotation.Super;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author: Tang dandan
 * @Date: 2020/1/29 12:57
 */
public class PraTest2 {
    public static void main(String[] args) {
        //配置xml文件
        //启动xml上下文
        BeanFactory  beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");
        lookInRealTime(beanFactory);
        lookInLazyTime(beanFactory);
        lookUpByType(beanFactory);
        lookUpByCollectionType(beanFactory);
        lookUpByAnnoTationType(beanFactory);
    }
    //按照注解的类型查找
    private static void lookUpByAnnoTationType(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, Object> annotation = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("按照注解类型查找 = " + annotation);
    }

    //按照集合类型查找
    private static void lookUpByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory)
        {
           ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User>  users= listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查询到的所有的集合对象："+users);
        }
    }

    //根据类型查找
    private static void lookUpByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);

    }

    private static void lookInLazyTime(BeanFactory beanFactory) {
       ObjectFactory<User>  objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }

    //实时查找
    public static void lookInRealTime(BeanFactory beanFactory)
    {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找:"+user);
    }
}
