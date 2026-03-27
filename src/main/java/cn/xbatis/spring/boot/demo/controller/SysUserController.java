package cn.xbatis.spring.boot.demo.controller;

import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import cn.xbatis.spring.boot.demo.service.SysUserService;
import cn.xbatis.spring.boot.demo.vo.SysUser2Vo;
import cn.xbatis.spring.boot.demo.vo.SysUser3Vo;
import cn.xbatis.spring.boot.demo.vo.SysUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/sys/user")
@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

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

    @RequestMapping("/pagerHelperTest")
    public PageInfo pagerHelperTest() {
        List list = sysUserService.pagerHelperTest();
        // 封装分页信息
        return new PageInfo<>(list);

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
