package Hsystem.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by hongjian on 2015/11/22.
 */
public class WebContextAwareUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;

    }

    public static <T> T getBean(String beanId) {

        return (T) applicationContext.getBean(beanId);

    }



}

