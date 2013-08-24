package org.mael.blog.web.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.google.common.base.Preconditions;

public class ReferenceHoldingBeanPostProcessor implements BeanPostProcessor,
        InitializingBean {

    private Class<?> clazz;

    private String className;

    private Object beanReference;

    public ReferenceHoldingBeanPostProcessor() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Preconditions.checkNotNull(this.className,
                "Class name must not be null.");

        this.clazz = Class.forName(this.className);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        if (clazz.isInstance(bean)) {
            this.beanReference = bean;
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    // Getters and Setters
    public Class<?> getClazz() {
        return this.clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @SuppressWarnings("unchecked")
    public <T> T getBeanReference() {
        return (T) this.beanReference;
    }

}
