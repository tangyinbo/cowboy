package com.cowboy.log.process;/**
 * Created by Administrator on 2017/12/15/0015.
 */

/**
 * 请求参数和响应结果打印
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 9:58
 **/
public interface RequestParamLogPrint {
    /**
     * 请求参数打印
     * @param typeName
     * @param methodName
     * @param requestParams
     */
    public void printRequestParam(String typeName,String methodName,Object[] requestParams);

    /**
     * 响应结果打印
     * @param typeName
     * @param methodName
     * @param result
     */
    public void printResponseReslt(String typeName,String methodName,Object result);
}
