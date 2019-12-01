package cn.cjxnsb.options;

import cn.cjxnsb.config.BaseConfiguration;
import cn.cjxnsb.entity.BaseEntity;

import java.sql.SQLException;
import java.util.Map;

public interface CreateTable {

    String SEPARATOR = " ";
    String SEPARATOR_NEXT = ",";
    String SEPARATOR_BEGIN = "(";
    String SEPARATOR_END = ")";
    String PRIMARY_KEY = "PRIMARY KEY(id)";
    String SEPARATOR_START = "create table ";

    Map<String,String> typeConversion = BaseConfiguration.defaultTypeConversion();

    Map<String,Integer> typeLength = BaseConfiguration.defaultTypeLength();

    Integer createTable(Class<? extends BaseEntity> clazz) throws SQLException;
}
