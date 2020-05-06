package com.smart.smile.context.typeconvert;

import org.springframework.core.convert.converter.Converter;

/**
 * 利用Convert接口实现类型转换
 * <p>
 * 另一种方式使用PropertityEditor方法实现
 *
 * @Author Zhiguo Chen
 * @Date 2020/3/15 17:29
 */
public class StringToInteger implements Converter<String, Integer> {
	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source);
	}
}
