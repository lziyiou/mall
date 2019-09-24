package com.imooc.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ConvertUtil {
    public static <T> T convertTFromPojo(Class<T> clazz, Object pojoBean) {

        if (pojoBean == null) {
            return null;
        }

        T target = null;
        try {
            target = clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert target != null;
        BeanUtils.copyProperties(pojoBean, target);
        return target;
    }
}
