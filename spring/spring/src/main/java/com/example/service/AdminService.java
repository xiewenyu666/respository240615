package com.example.service;

import com.example.dao.AdminDao;
import com.example.entity.*;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource//便于识别并实例化
    private AdminDao adminDao;


    //查询所有用户
    public List<Admin> findAll(Params params) {
        //3、基于内置方法获取数据库数据
        return adminDao.findAll(params);
    }
    //查询所有图书
    public List<Books> findAllbooks(Params params) {
        return adminDao.findAllbooks(params);
    }

    //按图书分类查询图书
    public List<Books> findbookbykind(Params params) { return adminDao.findbookbykind(params); }

    //所有订单
    public List<Idents> findAllidents(Params params) {
        return adminDao.findAllidents(params);
    }

    //我的购物车
    public List<Shopping> findAllmyshopping(String phone) {
        return adminDao.findAllmyshopping(phone);
    }

    public void updata(Admin admin) {
        adminDao.updataByPrimaryKeySelective(admin);
    }

    public void add(Admin admin) {}

    public void delete(String phone){adminDao.deleteByPrimaryKey(phone);}

    //登陆验证
    public Admin login(Admin admin) {
        if (admin.getPhone() == null || "".equals(admin.getPhone())) {
            System.out.println(admin.getPhone());
            throw new CustomException("用户名不能为空");
        }
        if (admin.getPassword() == null || "".equals(admin.getPassword())) throw new CustomException("密码不能为空");
        Admin user = adminDao.findByPhoneAndPassword(admin.getPhone(),admin.getPassword());
        if (user == null) throw new CustomException("用户名或密码输入错误");
        return user;
    }
    //注册验证
    public void register(registeradmin registeradmin) {
        if (registeradmin.getName() == null || "".equals(registeradmin.getName())) { throw new CustomException("昵称不能为空"); }
        if (registeradmin.getPhone() == null || "".equals(registeradmin.getPhone())) { throw new CustomException("用户名不能为空"); }
        if (registeradmin.getPassword() == null || "".equals(registeradmin.getPassword())) throw new CustomException("密码不能为空");
        if (!registeradmin.getPassword().equals(registeradmin.getConfirmPassword())) throw new CustomException("两次密码输入不一致");
        Admin user = adminDao.findByPhone(registeradmin.getPhone());
        if (user != null) throw new CustomException("用户名已存在");
        adminDao.register(registeradmin.getPhone(),registeradmin.getPassword(),registeradmin.getName(),"0",0,0,0);
    }

    //我的订单
    public List<Idents> findAllmyidents(String phone) {
        return adminDao.findAllmyidents(phone);
    }

}
