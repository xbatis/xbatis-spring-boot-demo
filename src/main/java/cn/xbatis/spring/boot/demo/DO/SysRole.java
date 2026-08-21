package cn.xbatis.spring.boot.demo.DO;

import cn.xbatis.db.annotations.Ignore;
import cn.xbatis.db.annotations.Table;
import cn.xbatis.db.annotations.TableField;
import cn.xbatis.db.annotations.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table
public class SysRole {

    @TableId
    private Integer id;

    private String name;

    @TableField(update = false, defaultValue = "{NOW}")
    private LocalDateTime createTime;

    @Ignore
    private String ignoreField;
}
