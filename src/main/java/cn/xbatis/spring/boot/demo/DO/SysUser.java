package cn.xbatis.spring.boot.demo.DO;

import cn.xbatis.db.annotations.ForeignKey;
import cn.xbatis.db.annotations.Table;
import cn.xbatis.db.annotations.TableField;
import cn.xbatis.db.annotations.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table
public class SysUser {

    @TableId
    private Integer id;

    private String name;

    @ForeignKey(SysRole.class)
    private Integer roleId;

    @TableField(update = false, defaultValue = "{NOW}")
    private LocalDateTime createTime;
}
