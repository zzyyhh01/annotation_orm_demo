package cn.cjxnsb.options;


import cn.cjxnsb.entity.BaseEntity;

import java.sql.SQLException;

public interface TableOptions {



    Integer createTable(Class<? extends BaseEntity> clazz) throws SQLException;



}
