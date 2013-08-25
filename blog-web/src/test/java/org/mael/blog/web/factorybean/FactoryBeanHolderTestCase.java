package org.mael.blog.web.factorybean;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FactoryBeanHolderTestCase {

    @Test
    @SuppressWarnings("resource")
    public void testHappyPath() {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                TestConfiguration.class);

        @SuppressWarnings("unchecked")
        FactoryBean<File> factoryBean = (FactoryBean<File>) context.getBean(
                ReferenceHoldingBeanPostProcessor.class).getBeanReference();

        System.out.println(factoryBean.getClass().getName());
        Assert.assertTrue(factoryBean instanceof FileFactoryBean);

    }

    @Configuration
    static class TestConfiguration {

        @Bean
        public BeanPostProcessor referenceHoldingBeanPostProcessor() {
            ReferenceHoldingBeanPostProcessor postProcessor = new ReferenceHoldingBeanPostProcessor();

            postProcessor
                    .setClassName("org.mael.blog.web.factorybean.FileFactoryBean");

            return postProcessor;
        }

        @Bean
        public FactoryBean<File> fileFactoryBean() {
            return new FileFactoryBean(
                    "/home/necromancer/Desktop/gits/someFile.txt");
        }

    }

}
