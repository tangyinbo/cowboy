package com.cowboy.sys.entity;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-13 11:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;

    @JSONField(name = "kaka")
    private String userName;
}
