package com.coder.hotel.util;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/14
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解是放在实体类对象的主键上，用来标识主键生成方式
 * AUTO_INCREMENT 自增长
 * UUID 表示使用UUID方式生成
 * INPUT 表示用户自己插入
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tableld {
    IdType value() default IdType.AUTO_INCREMENT;
}