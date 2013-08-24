package org.mael.blog.web.factorybean;

import java.io.File;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class FileFactoryBean extends AbstractFactoryBean<File> {

    private String filePath;

    public FileFactoryBean() {

    }

    public FileFactoryBean(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Class<?> getObjectType() {
        return File.class;
    }

    @Override
    protected File createInstance() throws Exception {
        return new File(this.filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
