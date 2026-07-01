package cn.xbatis.demo.generator;

import cn.xbatis.generator.core.FastGenerator;
import cn.xbatis.generator.core.config.GeneratorConfig;
import db.sql.api.DbType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class DemoFastGenerator {

    public static void main(String[] args) {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setName("test_db")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("data.sql")
                .build();

        new FastGenerator(new GeneratorConfig(
                DbType.H2,
                dataSource)
                .baseFilePath(System.getProperty("user.dir") + "/demo-generate")
                .basePackage("cn.xbatis.spring.boot.demo")
                .finishOpen(true)
                .tableConfig(tableConfig -> {
                    tableConfig.includeTable("sys_user", "sys_role");
                })
                .columnConfig(columnConfig -> {
                    columnConfig.disableUpdateColumns("create_time");
                })
                .entityConfig(entityConfig -> {
                    entityConfig.lombok(true).schema(true);
                })
                .mapperXmlConfig(mapperXmlConfig -> {
                    mapperXmlConfig.enable(true).resultMap(true).columnList(true);
                })
                .actionConfig(actionConfig -> {
                    actionConfig
                            .enableSave(true)
                            .enableUpdate(true)
                            .enableFind(true)
                            .enableGet(true)
                            .enableDelete(true)
                            .returnClass(Object.class.getName());
                })
        ).create();
    }
}
