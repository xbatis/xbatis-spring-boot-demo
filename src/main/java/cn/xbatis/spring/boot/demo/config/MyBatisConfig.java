package cn.xbatis.spring.boot.demo.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

/**
 * @author : rjw
 * @date : 2024-09-20
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public PageInterceptor pageHelper() {
        // 注意这里使用的 PageInterceptor
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}

