package org.mael.blog.web.config;

import org.mael.blog.dao.config.DaoContextConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoContextConfig.class)
public class ApplicationContextConfig {

}
