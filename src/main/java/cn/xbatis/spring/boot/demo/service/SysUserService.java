package cn.xbatis.spring.boot.demo.service;

import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import cn.xbatis.spring.boot.demo.vo.SysUserVo;

import java.util.List;

public interface SysUserService {

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    int delete(Integer id);

    SysUser get(Integer id);

    SysUserVo getUserInfo(Integer id);

    <T> Pager<T> search(String name, Pager<T> pager, Class<T> returnType);

    List pagerHelperTest();
}
