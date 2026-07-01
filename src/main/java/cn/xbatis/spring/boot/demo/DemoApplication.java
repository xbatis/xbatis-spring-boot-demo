package cn.xbatis.spring.boot.demo;

import cn.xbatis.core.mybatis.mapper.MybatisMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.XbatisDDLAutoScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@XbatisDDLAutoScan(entityPackages = "cn.xbatis.spring.boot.demo.DO")
@MapperScan(basePackages = "cn.xbatis.spring.boot.demo.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }
}
