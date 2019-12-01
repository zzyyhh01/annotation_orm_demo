package cn.cjxnsb.entity;

import cn.cjxnsb.annotation.MyField;
import cn.cjxnsb.annotation.Table;


@Table
public class User extends BaseEntity {
    @MyField
    private Integer id;
    @MyField
    private String name;
    @MyField
    private String sex;
    @MyField
    private String phone;


    public User() {
    }

    public User(Integer id, String name, String sex, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
