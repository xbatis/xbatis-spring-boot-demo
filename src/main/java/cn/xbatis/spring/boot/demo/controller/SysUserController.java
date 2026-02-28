package cn.xbatis.spring.boot.demo.controller;

import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import cn.xbatis.spring.boot.demo.mapper.MybatisBasicMapper;
import cn.xbatis.spring.boot.demo.mapper.SysUserMapper;
import cn.xbatis.spring.boot.demo.service.SysUserService;
import cn.xbatis.spring.boot.demo.vo.SysUser2Vo;
import cn.xbatis.spring.boot.demo.vo.SysUser3Vo;
import cn.xbatis.spring.boot.demo.vo.SysUserVo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/sys/user")
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private MybatisBasicMapper mybatisBasicMapper;

    @RequestMapping("/xmlPaging")
    public Pager<SysUser> xmlPaging() {
        return sysUserMapper.xmlPaging(Pager.of(1, 2), 1);
    }

    @Transactional
    @RequestMapping("/save")
    public SysUser save(SysUser sysRole) {
        sysRole.setCreateTime(LocalDateTime.now());
        sysUserService.save(sysRole);
        return sysRole;
    }

    @Transactional
    @RequestMapping("/update")
    public SysUser update(SysUser sysRole) {
        sysRole.setCreateTime(LocalDateTime.now());
        sysUserService.update(sysRole);
        return sysRole;
    }

    @Transactional
    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable Integer id) {
        return sysUserService.delete(id);
    }

    @RequestMapping("/get")
    public SysUser get(Integer id) {
        return sysUserService.get(id);
    }

    @RequestMapping("/info/{id}")
    public SysUserVo getInfo(@PathVariable Integer id) {
        return sysUserService.getUserInfo(id);
    }

    /**
     * 根据name搜索 根据searchType 动态映射Vo类
     *
     * @param name
     * @param pager
     * @param searchType
     * @return
     */
    @RequestMapping("/search")
    public Pager<?> search(String name, Pager<SysUserVo> pager, @RequestParam(defaultValue = "0") Integer searchType) {

        Class type = SysUserVo.class;

        switch (searchType) {
            case 0: {
                type = SysUserVo.class;
                break;
            }
            case 1: {
                type = SysUser2Vo.class;
                break;
            }
            case 2: {
                type = SysUser3Vo.class;
                break;
            }
        }

        return sysUserService.search(name, pager, type);
    }
}
