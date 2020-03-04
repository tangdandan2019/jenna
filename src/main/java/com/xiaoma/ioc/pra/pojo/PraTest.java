package com.xiaoma.ioc.pra.pojo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @Author: Tang dandan
 * @Date: 2020/1/28 17:16
 */
public class PraTest {
    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
           propertyDescriptor ->
           {
               Class<?> propertyType = propertyDescriptor.getPropertyType();
               String name = propertyDescriptor.getName();
               if("age".equals(name)){
                 propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
               }
           });
    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
           Integer a = Integer.valueOf(text);
           setValue(a);
        }
    }
}
