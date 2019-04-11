package com.jt.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)//运行时有效
@Target(ElementType.METHOD)
public @interface CacheAnno {
	String key(); //定义key值
	int index();//参数定义位置
	Class targetClass();//定义目标类型
	CACHE_TYPE cacheType() default CACHE_TYPE.FIND;

	//枚举定义泛型类型
	enum CACHE_TYPE{
		FIND,	//定义查找
	
		UPDATE  //定义更新
	}
}
