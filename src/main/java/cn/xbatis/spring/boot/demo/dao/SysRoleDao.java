package cn.xbatis.spring.boot.demo.dao;

import cn.xbatis.core.mvc.Dao;
import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.spring.boot.demo.DO.SysRole;

/**
 * <p>
 * Dao 接口
 * </p>
 *
 * @author
 * @since 2023-11-16
 */
public interface SysRoleDao extends Dao<SysRole, Integer> {

    Pager<SysRole> search(String name, Pager<SysRole> pager);

    int save(SysRole sysRole);

    int update(SysRole sysRole);

    int deleteById(Integer id);
}
