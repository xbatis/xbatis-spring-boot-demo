package cn.xbatis.spring.boot.demo.config;

import cn.xbatis.core.XbatisGlobalConfig;
import cn.xbatis.spring.boot.demo.mapper.MybatisBasicMapper;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XbatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (configuration) -> {
            //设置单Mapper的类
            XbatisGlobalConfig.setSingleMapperClass(MybatisBasicMapper.class);
        };
    }

}