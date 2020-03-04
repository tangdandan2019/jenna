package com.xiaoma.ioc.container;

import com.xiaoma.ioc.pra2.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author: Tang dandan
 * @Date: 2020/2/3 16:07
 */
@Configuration
public class AnnotationIocContainer {
    public static void main(String[] args) {
        //定义底层容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将此类作为配置类
        applicationContext.register(AnnotationIocContainer.class);
        //启动应用上下文
        applicationContext.refresh();
        lookUpByCollectionType(applicationContext);
        //停止容器
        applicationContext.close();
    }
   @Bean
    public User user(){
        User user = new User();
        user.setId("1l");
        user.setName("dandan");
        return user;
    }
    //按照集合类型查找
    private static void lookUpByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory)
        {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users= listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查询到的所有的集合对象："+users);
        }
    }
}
