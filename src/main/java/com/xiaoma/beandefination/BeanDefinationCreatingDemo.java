package com.xiaoma.beandefination;

import com.xiaoma.ioc.pra2.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * bean定义
 * @Author: Tang dandan
 * @Date: 2020/2/3 17:21
 */
public class BeanDefinationCreatingDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
    }
}
