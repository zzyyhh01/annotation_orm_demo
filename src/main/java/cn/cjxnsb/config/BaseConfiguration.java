package cn.cjxnsb.config;

import cn.cjxnsb.entity.DataType;

import java.util.HashMap;
import java.util.Map;


/**
 * 基础配置
 */
public abstract class BaseConfiguration {

    /**
     * 设置默认数据类型
     * @return 默认数据类型集合
     */
    @Deprecated
    public static Map<String, DataType> defaultDataTypes(){
        Map<String,DataType> dataTypeMap = new HashMap<String, DataType>();
        dataTypeMap.put("String",new DataType("VARCHAR",255));

        DataType integer = new DataType("INTEGER", 11);
        dataTypeMap.put("Integer",integer);
        dataTypeMap.put("int",integer);

        DataType aFloat = new DataType("FLOAT", 11);
        dataTypeMap.put("Float",aFloat);
        dataTypeMap.put("float",aFloat);

        DataType aDouble = new DataType("DOUBLE", 18);
        dataTypeMap.put("double",aDouble);
        dataTypeMap.put("Double",aDouble);
        return dataTypeMap;
    }


    /**
     * 默认类型转换
     * @return 默认类型转换集合
     */
    public static Map<String,String> defaultTypeConversion(){
        Map<String,String> defaultTypeConversionMap = new HashMap<String, String>();

        defaultTypeConversionMap.put("String","VARCHAR");

        defaultTypeConversionMap.put("Integer","INTEGER");
        defaultTypeConversionMap.put("int","INT");

        defaultTypeConversionMap.put("Float","FLOAT");
        defaultTypeConversionMap.put("float","FLOAT");

        defaultTypeConversionMap.put("double","DOUBLE");
        defaultTypeConversionMap.put("Double","DOUBLE");

        return defaultTypeConversionMap;
    }

    /**
     * 指定默认类型的长度
     * @return 默认类型长度集合
     */
    public static Map<String,Integer> defaultTypeLength(){
        Map<String,Integer> defaultTypeLength = new HashMap<String, Integer>();

        defaultTypeLength.put("VARCHAR",255);

        defaultTypeLength.put("INTEGER",11);

        defaultTypeLength.put("INT",11);

        defaultTypeLength.put("FLOAT",15);

        defaultTypeLength.put("DOUBLE",18);

        return defaultTypeLength;
    }
}
