package com.xiaoma.ioc.container;

import com.xiaoma.ioc.pra2.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Author: Tang dandan
 * @Date: 2020/2/3 16:07
 */
public class IocContainer {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup.xml";
        int countBean = reader.loadBeanDefinitions(location);
        System.out.println("countBean = " + countBean);
        lookUpByCollectionType(beanFactory);
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
