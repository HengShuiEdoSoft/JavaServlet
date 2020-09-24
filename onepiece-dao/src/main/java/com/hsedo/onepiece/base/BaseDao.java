package com.hsedo.onepiece.base;

import java.util.List;
import java.util.Map;

/**
 * @author  作者:CC
 * @Date	时间: 2020年8月31日 下午4:01:48
 * 类说明
 * dao层的 基础操作接口
 */
public interface BaseDao<T> {
	T getModel(int str);

    List<T> selectList(Map map);

    int add(T t);

    int update(T t);

    int delete(Map map);
}
