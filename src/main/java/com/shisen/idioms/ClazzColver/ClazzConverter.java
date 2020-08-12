package com.shisen.idioms.ClazzColver;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Collection;
import java.util.List;

/**
 * 类转化器
 * <p>
 * 借助FastJson从一个类转化为另一个类
 * 主要是用来转化同一个模型的Model和DO
 * 他们具有基本相同的属性名称
 *
 * @author shisen
 * @since 1.0.3
 */
public class ClazzConverter {

    /**
     * 具有相同属性名称的对象转化,支持泛型
     *
     * @param srcClazz
     * @param typeReference
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T1, T2> T1 converterClass(final T2 srcClazz, TypeReference<T1> typeReference) {
        return JSONObject.parseObject(JSONObject.toJSONString(srcClazz), typeReference);
    }

    /**
     * 具有相同属性名称的对象转化
     *
     * @param srcClazz
     * @param dstClazz
     * @return
     */
    public static <T1, T2> T1 converterClass(final T2 srcClazz, Class<T1> dstClazz) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(srcClazz);
        return null == jsonObject ? null : JSONObject.toJavaObject(jsonObject, dstClazz);
    }

    /**
     * 集合转化
     *
     * @param srcClazzCollection
     * @param dstClazz
     * @return
     */
    public static <T1, T2> Collection<T1> converterClass(final Collection<T2> srcClazzCollection, Class<T1> dstClazz) {
        JSONArray jsonArray = (JSONArray) JSONObject.toJSON(srcClazzCollection);
        return JSONArray.parseArray(jsonArray.toJSONString(), dstClazz);
    }

    /**
     * 数组转化
     *
     * @param srcClazzArray
     * @param dstClazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T1, T2> T1[] converterClass(final T2[] srcClazzArray, Class<T1> dstClazz) {
        String jsonString = JSONObject.toJSONString(srcClazzArray);
        List<T1> result = JSONArray.parseArray(jsonString, dstClazz);
        return result == null ? null : (T1[]) result.toArray();
    }

}