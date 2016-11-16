package com.easycode.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RuleParameter {
	
	// 参数非空类型
	public enum  NullType{
		NULL, NOTNULL
	};

	public NullType nullType() default NullType.NULL;
	
	//字符串长度或者数字大小限制
	public int lengthMax() default -1;
	
	public int lenghtMin() default -1;
	
	//sql注入检测
	public enum SqlInq{
		YES,NO
	}
	
	public SqlInq sqlInq () default SqlInq.NO;
	
	public String value ();
}
