package cn.cjxnsb.entity;

import cn.cjxnsb.annotation.MyField;
import cn.cjxnsb.annotation.MyField;
import cn.cjxnsb.annotation.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Table
@Setter
@Getter
public class User extends BaseEntity {
    @MyField
    private Integer id;
    @MyField
    private String name;
    @MyField
    private String sex;
    @MyField
    private String phone;
}
