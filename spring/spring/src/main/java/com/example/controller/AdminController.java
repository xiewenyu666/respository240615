package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.entity.Params;
import com.example.entity.registeradmin;
import com.example.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource//便于识别并实例化
    private AdminService adminService;

    @PostMapping("/login")
    public Result adminlogin(@RequestBody Admin admin) {

        Admin loginuser = adminService.login(admin);
        return Result.success(loginuser);

    }

    @PostMapping("/register")
    public Result adminregister(@RequestBody registeradmin registeradmin) {

        adminService.register(registeradmin);
        return Result.success();

    }
    //所有用户
    @GetMapping("/search")
    public Result findAll(Params params) {
        return Result.success(adminService.findAll(params));
    }

    //所有图书
    @GetMapping("/searchbook")
    public Result findAllbooks(Params params) {
        return Result.success(adminService.findAllbooks(params));
    }

    //按图书分类查询图书
    @GetMapping("/searchbookbykind")
    public Result findbookbykind(Params params) {
        return Result.success(adminService.findbookbykind(params));
    }

    //我的购物车
    @GetMapping("/searchmyshopping")
    public Result findAllmyshopping(Params phone_data) {
        return Result.success(adminService.findAllmyshopping(phone_data.getPhone()));
    }

    //所有订单
    @GetMapping("/searchident")
    public Result findAllidents(Params params) {
        return Result.success(adminService.findAllidents(params));
    }

    //我的订单
    @GetMapping("/searchmyident")
    public Result findAllmyidents(Params params) {
        return Result.success(adminService.findAllmyidents(params.getPhone()));
    }

    @PostMapping
    public Result save(@RequestBody Admin admin){
        if (admin.getPhone() == null) adminService.add(admin);
        else adminService.updata(admin);
        return Result.success();
    }
}
