package cn.xbatis.spring.boot.demo.service.impl;

import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import cn.xbatis.spring.boot.demo.dao.SysUserDao;
import cn.xbatis.spring.boot.demo.mapper.SysUserMapper;
import cn.xbatis.spring.boot.demo.service.SysUserService;
import cn.xbatis.spring.boot.demo.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public void save(SysUser sysUser) {
        sysUser.setCreateTime(LocalDateTime.now());
        sysUserDao.save(sysUser);
    }

    @Override
    public void update(SysUser sysUser) {
        sysUserDao.update(sysUser);
    }

    @Override
    public int delete(Integer id) {
        return sysUserDao.deleteById(id);
    }

    @Override
    public SysUser get(Integer id) {
        return sysUserMapper.getOne1();
        //return sysUserDao.getById(id);
    }

    @Override
    public SysUserVo getUserInfo(Integer id) {
        return sysUserDao.getUserInfo(id);
    }

    @Override
    public <T> Pager<T> search(String name, Pager<T> pager, Class<T> returnType) {
        return sysUserDao.search(name, pager, returnType);
    }

    @Override
    public List pagerHelperTest() {
        PageHelper.startPage(1, 20);
        return sysUserDao.pagerHelperTest();
    }
}
