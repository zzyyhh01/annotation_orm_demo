package cn.cjxnsb;

import cn.cjxnsb.annotation.MyField;
import cn.cjxnsb.annotation.Table;
import cn.cjxnsb.entity.User;
import cn.cjxnsb.options.TableOptions;
import cn.cjxnsb.options.impl.CreateTableImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    private static final String separatorStart = "create table ";
    private static final String separator = " ";
    private static final String separatorNext = ",";
    private static final String separatorBegin = "(";
    private static final String separatorEnd = ")";
    private static final String primaryKey = "PRIMARY KEY(id)";


    @Test
    public void t1() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> user = Class.forName("cn.cjxnsb.entity.User");



        Table table = user.getAnnotation(Table.class);

        System.out.println(table.value());
        String tableName;
        if ("".equals(table.value()))
            tableName = user.getSimpleName();
        else
            tableName = table.value();


        StringBuilder sql = new StringBuilder();

        sql.append(separatorStart).append(tableName).append(separatorBegin);


        Field[] declaredFields = user.getDeclaredFields();

        int i = 0;
        for (i = 0; i < declaredFields.length; i++) {
            MyField myField = declaredFields[i].getAnnotation(MyField.class);
            String columnName;
            if ("".equals(myField.columnName().trim()))
                columnName = declaredFields[i].getName();
            else
                columnName = myField.columnName();

            sql.append(columnName)
               .append(separator)
               .append(myField.typeName())
               .append(separatorBegin)
               .append(myField.length())
               .append(separatorEnd)
               .append(separatorNext);
        }

        sql.append(primaryKey+separatorEnd);

        System.out.println(sql);

    }


    @Test
    public void t2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String s : list) {
            if (s.equals("2"))
                continue;
            System.out.println(s);
        }
    }

    @Test
    void t3() throws SQLException {
        User user = new User();
        user.createTable();
    }




    @Test
    void t4() throws NoSuchFieldException {
        Class<User> aClass = User.class;
        Field name = aClass.getDeclaredField("name");
        String simpleName = name.getType().getSimpleName();
        System.out.println(simpleName);
    }

    @Test
    void t5(){
    }

}
