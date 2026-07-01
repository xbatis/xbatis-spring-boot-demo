package cn.xbatis.spring.boot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.XbatisDDLAutoScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@XbatisDDLAutoScan(entityPackages = "cn.xbatis.spring.boot.demo.DO")
@EnableTransactionManagement
@MapperScan("cn.xbatis.spring.boot.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
