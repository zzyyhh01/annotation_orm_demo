package cn.cjxnsb.entity;

public class Column {
    private String columnName;
    private String typeName;
    private Integer length;


    public Column(String columnName, String typeName, Integer length) {
        this.columnName = columnName;
        this.typeName = typeName;
        this.length = length;
    }


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnName='" + columnName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", length=" + length +
                '}';
    }
}
