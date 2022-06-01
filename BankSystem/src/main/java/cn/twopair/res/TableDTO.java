package cn.twopair.res;

import lombok.Data;

import java.util.Vector;

/**
 * @description:
 * @author: 李佳骏
 * @time: 2021/12/19 23:39
 */
@Data
public class TableDTO {
    private Vector<Vector<Object>> data;
    //返回条数
    private Integer totalCount;

}
