package com.shaw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//类注解
@Retention(RetentionPolicy.RUNTIME)//运行时注解
public @interface OracleDataBase {

}
