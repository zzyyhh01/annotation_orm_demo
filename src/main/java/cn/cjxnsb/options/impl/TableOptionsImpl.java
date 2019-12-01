package cn.cjxnsb.options.impl;

import cn.cjxnsb.entity.BaseEntity;
import cn.cjxnsb.options.TableOptions;
import cn.cjxnsb.options.adapter.OptionAdapter;

import java.sql.SQLException;

public class TableOptionsImpl implements TableOptions {

    private OptionAdapter optionAdapter;

    public TableOptionsImpl(){
        optionAdapter = new OptionAdapter(new CreateTableImpl());
    }

    @Override
    public Integer createTable(Class<? extends BaseEntity> clazz) throws SQLException {
        return optionAdapter.createTable(clazz);
    }
}
