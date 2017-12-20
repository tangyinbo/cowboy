package com.cowboy.comon.model.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统通用返回信息封装
 * Created by cowboy on 2017-12-17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable{
    /**
     * 系统响应码
     * */
    private String code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应结果
     */
    private T result;
    /**
     * 构建处理失败结果
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildFailResult(CommonResultCode commonResultCode){
        CommonResponse response = buildSuccessResult(commonResultCode,null);
        return response;
    }
    /**
     * 构建处理失败结果
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildFailResult(String msg){
        CommonResponse response = buildSuccessResult(CommonResultCode.FAIL,null);
        response.setMsg(msg);
        return response;
    }

    /**
     * 构建处理失败结果
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildFailResult(T result,String msg){
        CommonResponse response = buildSuccessResult(CommonResultCode.FAIL,result);
        response.setMsg(msg);
        return response;
    }

    /**
     * 构建处理失败结果
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildFailResult(T result){
        return buildSuccessResult(CommonResultCode.FAIL,result);
    }

    /**
     * 构建成功结果
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildSuccessResult(T result){
        return buildSuccessResult(CommonResultCode.SUCCESS,result);
    }

    /**
     * 构建成功响应
     * @param <T>
     * @return
     */
    public static <T> CommonResponse<T> buildSuccessResult(){
        return buildSuccessResult(CommonResultCode.SUCCESS,null);
    }

    /**
     * 创建响应信息
     * @param commonResultCode 系统响应码封装
     * @param result 返回结果
     * @return
     */
    public static <T> CommonResponse<T> buildSuccessResult(CommonResultCode commonResultCode,T result){
        CommonResponse commonResponse = new CommonResponse<T>();
        commonResponse.setCode(commonResultCode.getCode());
        commonResponse.setMsg(commonResultCode.getDesc());
        commonResponse.setResult(result);
        return commonResponse;
    }
}
