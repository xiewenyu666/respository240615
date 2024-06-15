package com.example.dao;

import com.example.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//注明接口，以便能够使其实例化
public interface AdminDao {

    //1、基于注解的方式获取数据库的数据
    //@Select("select * from user")
    //查询所有用户
    List<Admin> findAll(@Param("params") Params params);

    //所有图书
    List<Books> findAllbooks(@Param("params") Params params);

    //按图书分类查询图书
    List<Books> findbookbykind(@Param("params") Params params);

    //查询所有订单
    List<Idents> findAllidents(@Param("params") Params params);

    //我的购物车
    @Select("select * from shopping where phone = #{phone}")
    List<Shopping> findAllmyshopping(@Param("phone") String phone);

    //我的订单
    @Select("select * from idents where phone = #{phone}")
    List<Idents> findAllmyidents(@Param("phone") String phone);

    void updataByPrimaryKeySelective(Admin admin);

    void deleteByPrimaryKey(String phone);

    @Select("select * from admin where phone = #{phone} and password = #{password} limit 1")
    Admin findByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);//查询用户名和密码是否存在

    @Select("select * from admin where phone = #{phone} limit 1")
    Admin findByPhone(@Param("phone") String phone);//查询用户主键

    @Insert("INSERT INTO admin (phone, password, name, priority,balance,vip_num,balance_sums) VALUES (#{phone}, #{password}, #{name}, #{priority},#{balance},#{vip_num},#{balance_sums})")
    void register(@Param("phone") String phone, @Param("password") String password, @Param("name") String name, @Param("priority") String priority, @Param("balance") Integer balance, @Param("vip_num") Integer vip_num, @Param("balance_sums") Integer balance_sums);//注册用户

}
