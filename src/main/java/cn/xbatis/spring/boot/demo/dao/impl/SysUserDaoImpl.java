package cn.xbatis.spring.boot.demo.dao.impl;

import cn.xbatis.core.mvc.impl.DaoImpl;
import cn.xbatis.core.mybatis.mapper.context.Pager;
import cn.xbatis.core.sql.util.WhereUtil;
import cn.xbatis.spring.boot.demo.DO.SysRole;
import cn.xbatis.spring.boot.demo.DO.SysUser;
import cn.xbatis.spring.boot.demo.dao.SysUserDao;
import cn.xbatis.spring.boot.demo.mapper.SysUserMapper;
import cn.xbatis.spring.boot.demo.vo.SysUserVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Dao 实现类
 * </p>
 *
 * @author
 * @since 2023-11-16
 */
@Repository
public class SysUserDaoImpl extends DaoImpl<SysUser, Integer> implements SysUserDao {

    @Autowired
    public SysUserDaoImpl(SysUserMapper sysUserMapper) {
        super(sysUserMapper);
    }

    @Override
    protected SysUserMapper getMapper() {
        return (SysUserMapper) super.getMapper();
    }

    @Override
    public SysUserVo getUserInfo(Integer id) {
        return queryChain()
                .select(SysUser.class)
                .select(SysRole.class)
                .select(SysUser::getName, c -> c.concat("").as("copy_name"))
                .from(SysUser.class)
                .join(SysUser.class, SysRole.class)
                .eq(SysUser::getId, id)
                .returnType(SysUserVo.class)
                .get();

    }

    @Override
    public <T> Pager<T> search(String name, Pager<T> pager, Class<T> returnType) {
        return queryChain()
                .forSearch()
                .select(SysUser.class)
                .select(SysRole.class)
                .select(SysUser::getName, c -> c.concat("").as("copy_name"))
                .from(SysUser.class)
                .join(SysUser.class, SysRole.class)
                .like(SysUser::getName, name)
                .returnType(returnType)
                .paging(pager);
    }

    @Override
    public List pagerHelperTest() {
        List<SysUser> list;
//        PageHelper.startPage(1, 10);
//        list = this.queryChain()
//                .gt(SysUser::getId, 0)
//                .list();
//
//        for(SysUser sysUser:list){
//            System.out.println(sysUser.getRoleId().intValue());
//        }

        PageHelper.startPage(1, 10);
        list = this.getMapper().selectList(SysUser.class, "select * from sys_user t where ?", WhereUtil.create(where -> {
            where.gte(SysUser::getId, 1);
        }));

        for (SysUser sysUser : list) {
            System.out.println(sysUser.getRoleId().intValue());
        }

        PageHelper.startPage(1, 10);
        list = this.getMapper().selectList(SysUser.class, "select * from sys_user t where ? and ?", WhereUtil.create(where -> {
            where.eq(SysUser::getId, 1);
        }), WhereUtil.create(where -> {
            where.in(SysUser::getId, 1, 2, 3, 4, 5, 6);
        }));

        for (SysUser sysUser : list) {
            System.out.println(sysUser.getRoleId().intValue());
        }

        PageHelper.startPage(1, 10);
        list = getMapper().list2(0);


        for (SysUser sysUser : list) {
            System.out.println(sysUser.getRoleId().intValue());
        }

        PageHelper.startPage(1, 10);
        list = getMapper().list3(0, 0);

        for (SysUser sysUser : list) {
            System.out.println(sysUser.getRoleId().intValue());
        }

        PageHelper.startPage(1, 10);
        list = getMapper().list4(WhereUtil.create(where -> {
            where.gte(SysUser::getId, 1);
        }), WhereUtil.create(where -> {
            where.in(SysUser::getId, 1, 2, 3, 4, 5, 6, 7);
        }));

        for (SysUser sysUser : list) {
            System.out.println(sysUser.getRoleId().intValue());
        }


        return list;
    }
}
