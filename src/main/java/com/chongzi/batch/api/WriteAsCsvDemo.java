package com.chongzi.batch.api;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple3;

/**
 * 将DataSet以CSV格式写出到存储系统
 * hdfs文件路径：
 *     hdfs:///path/to/data
 * 本地文件路径：
 *     file:///path/to/data
 */
public class WriteAsCsvDemo {
    public static void main(String[] args) throws Exception {
        // 1.设置运行环境，准备运行的数据
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<Tuple3<String, String, Double>> input = env.fromElements(
                new Tuple3<>("lisi","shandong",2400.00),
                new Tuple3<>("zhangsan","hainan",2600.00),
                new Tuple3<>("wangwu","shandong",2400.00),
                new Tuple3<>("zhaoliu","hainan",2600.00),
                new Tuple3<>("xiaoqi","guangdong",2400.00),
                new Tuple3<>("xiaoba","henan",2600.00)
        );
        //2.将DataSet写出到存储系统
        input.writeAsCsv("D:/projects/my-flink-text/students.csv","#","|");
        //3.执行程序
        env.execute();
    }
}
