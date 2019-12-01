package cn.cjxnsb.options.adapter;


import cn.cjxnsb.entity.BaseEntity;
import cn.cjxnsb.options.CreateTable;
import cn.cjxnsb.options.TableOptions;

import java.sql.SQLException;

public class OptionAdapter implements TableOptions{

    private CreateTable createTable;

    public OptionAdapter(CreateTable createTable){
        this.createTable = createTable;
    }

    @Override
    public Integer createTable(Class<? extends BaseEntity> clazz) throws SQLException {
        return createTable.createTable(clazz);
    }


    public CreateTable getCreateTable() {
        return createTable;
    }

    public void setCreateTable(CreateTable createTable) {
        this.createTable = createTable;
    }
}
