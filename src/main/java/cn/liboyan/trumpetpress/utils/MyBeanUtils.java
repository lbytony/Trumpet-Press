package cn.liboyan.trumpetpress.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * MyBeanUtils
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/4
 */
public class MyBeanUtils {

    public static String[] getNullPropertyNames(Object src) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(src);
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
}
