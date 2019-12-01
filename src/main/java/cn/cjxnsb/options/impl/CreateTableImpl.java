package cn.cjxnsb.options.impl;

import cn.cjxnsb.annotation.MyField;
import cn.cjxnsb.annotation.Table;
import cn.cjxnsb.entity.BaseEntity;
import cn.cjxnsb.entity.Column;
import cn.cjxnsb.jdbc.JdbcTemplate;
import cn.cjxnsb.options.CreateTable;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateTableImpl implements CreateTable {


    @Override
    public Integer createTable(Class<? extends BaseEntity> clazz) throws SQLException {
        String sql = getSql(clazz);
        System.out.println(sql);
        Statement statement = JdbcTemplate.getStatement();
        statement.execute(sql);
        return null;
    }


    /**
     * 根据class获取字段信息
     * @return 字段信息列表
     */
    private List<Column> getColumns(Class<? extends BaseEntity> clazz){
        List<Column> columns = new ArrayList<Column>();
        Field[] fields = clazz.getDeclaredFields();
        String columnName;
        String typeName;
        Integer length;
        for (Field field : fields) {
            MyField fieldAnnotation = field.getAnnotation(MyField.class);
            if (fieldAnnotation == null)
                continue;
            if (fieldAnnotation.columnName().trim().equals(""))
                columnName = field.getName();
            else
                columnName = fieldAnnotation.columnName();

            if (fieldAnnotation.typeName().trim().equals(""))
                typeName = field.getType().getSimpleName();
            else
                typeName = fieldAnnotation.typeName();

            //将java类型转为mysql类型转换
            typeName = typeConversion.get(typeName);

            if (fieldAnnotation.length() == -1)
                length = typeLength.get(typeName);
            else
                length = fieldAnnotation.length();
            columns.add(new Column(columnName,typeName,length));
        }

        return columns;
    }

    /**
     * 根据class获取表名信息
     * @return 表名
     */
    private String getTableName(Class<? extends BaseEntity> clazz){
        Table table = clazz.getAnnotation(Table.class);
        if (table.value().trim().equals(""))
            return clazz.getSimpleName().toLowerCase();
        else
            return table.value();
    }

    /**
     * 根据表明和字段信息生成sql语句
     * @return 建表sql语句
     */
    private String getSql(Class<? extends BaseEntity> clazz){
        String tableName = getTableName(clazz);
        List<Column> columns = getColumns(clazz);

        StringBuilder sql = new StringBuilder();

        sql.append(SEPARATOR_START).append(tableName).append(SEPARATOR_BEGIN);

        for (Column column : columns) {
            sql.append(column.getColumnName())
                    .append(SEPARATOR)
                    .append(column.getTypeName())
                    .append(SEPARATOR_BEGIN)
                    .append(column.getLength())
                    .append(SEPARATOR_END)
                    .append(SEPARATOR_NEXT);
        }

        sql.append(PRIMARY_KEY+SEPARATOR_END);

        return sql.toString();
    }
}
