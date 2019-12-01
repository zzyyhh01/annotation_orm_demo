# annotation_orm_demo
使用注解实现简单的orm映射
# 当前版本：0.5
##简介
使用注解加反射的机制，实现orm映射。
此版本只有对应的建表功能
## 注解
### @Table
#### 属性 
+ value 指定表名 默认 表名 
#### 功能
标记在类上，value 指定表名，默认类名小写
### @MyField
#### 属性

+ columnName 字段名     默认变量名
+ typeName   字段类型   默认变量类型
+ length     字段长度   默认
## 案例
~~~java
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
    
    //省略 get set方法
}
class test{
    @Test
    public void t3() throws SQLException {
        User user = new User();
        user.createTable();
    }
}
~~~
1. 需要继承BaseEntity类
2. 调用实体类的createTable()方法即可建表
