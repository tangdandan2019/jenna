package com.xiaoma.beandefination;

import com.xiaoma.ioc.pra2.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Author: Tang dandan
 * @Date: 2020/2/24 16:31
 */
@Import(AnnotationBeanDefinationDemo.Config.class)
public class AnnotationBeanDefinationDemo {
    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册
        applicationContext.register(AnnotationBeanDefinationDemo.class);
        //注册bean的方式 1,@bean 2,@component 3,@import
        applicationContext.refresh();
        System.out.println("config类型下的所有的bean："+applicationContext.getBeansOfType(Config.class));
        System.out.println("User类型下的所有的bean："+applicationContext.getBeansOfType(User.class));
        //关闭上下文
        applicationContext.close();
    }
    @Component
    public static class Config
    {
        @Bean(name = {"user","dandanUser"})
        public User user()
        {
            User user = new User();
            user.setId("1");
            user.setName("dandan");
            return user;
        }
    }
}
