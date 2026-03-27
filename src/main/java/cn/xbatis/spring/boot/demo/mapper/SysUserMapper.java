package cn.xbatis.spring.boot.demo.mapper;

import cn.xbatis.core.mybatis.mapper.MybatisMapper;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import db.sql.api.impl.cmd.struct.Where;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author
 * @since 2023-11-16
 */
@Mapper
public interface SysUserMapper extends MybatisMapper<SysUser> {

    SysUser getOne1();

    @Flush
    List<SysUser> list2(Integer id);

    @Flush
    List<SysUser> list3(Integer id1, @Param("id2") Integer id2);

    @Flush
    List<SysUser> list4(Where id1, @Param("id2") Where id2);
}
