package com.cowboy.comon.model.sys;/**
 * Created by Administrator on 2017/12/20/0020.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-20 11:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {
    private int currentPage;
    private int pageCount;
    private int pageSize;
    private List<T> rows;
}
