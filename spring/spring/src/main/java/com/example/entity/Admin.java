package com.example.entity;

import javax.persistence.*;

@Table(name = "admin")
public class Admin {

    @Id//主键
    @Column(name = "phone")
    private String phone;

    @Column(name = "password")//与表中的元素一一映射
    private String password;

    @Column(name = "name")//与表中的元素一一映射
    private String name;

    @Column(name = "priority")
    private String priority;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "vip_num")
    private Integer vip_num;

    @Column(name = "balance_sums")
    private Integer balance_sums;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passward) {
        this.password = passward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getVIP_num() {
        return vip_num;
    }

    public void setVIP_num(Integer vip_num) {
        this.vip_num = vip_num;
    }

    public Integer getBalance_sums() {
        return balance_sums;
    }

    public void setBalance_sums(Integer balance_sums) {
        this.balance_sums = balance_sums;
    }

}
