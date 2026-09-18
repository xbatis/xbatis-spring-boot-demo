package cn.xbatis.spring.boot.demo.mapper;

import cn.xbatis.core.mybatis.mapper.MybatisMapper;
import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.datasource.routing.DS;
import cn.xbatis.db.annotations.Paging;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    @Paging
    @DS("master")
    Pager<SysUser> xmlPaging(Pager pager, @Param("id") Integer id);
}
