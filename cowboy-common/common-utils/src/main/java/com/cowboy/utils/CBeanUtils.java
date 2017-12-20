package com.cowboy.utils;/**
 * Created by Administrator on 2017/12/20/0020.
 */

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-20 15:11
 **/
public class CBeanUtils {
    private static final Mapper mapper = new DozerBeanMapper();

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
