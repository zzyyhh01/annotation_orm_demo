package cn.cjxnsb.entity;


import cn.cjxnsb.options.TableOptions;
import cn.cjxnsb.options.impl.TableOptionsImpl;

import java.sql.SQLException;


public abstract class BaseEntity{


    private TableOptions tableOptions;

    BaseEntity(){
        tableOptions = new TableOptionsImpl();
    }



    public Integer createTable() throws SQLException {
       return tableOptions.createTable(this.getClass());
    }



}
