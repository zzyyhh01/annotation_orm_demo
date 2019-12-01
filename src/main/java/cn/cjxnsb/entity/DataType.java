package cn.cjxnsb.entity;

/**
 * 数据类型
 */
@Deprecated
public class DataType {
    //类型名称
    private String typeName;
    //长度
    private Integer length;

    public DataType(String dataName, Integer length) {
        this.typeName = dataName;
        this.length = length;
    }

    public String getDataName() {
        return typeName;
    }

    public void setDataName(String dataName) {
        this.typeName = dataName;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "dataName='" + typeName + '\'' +
                ", length=" + length +
                '}';
    }
}
