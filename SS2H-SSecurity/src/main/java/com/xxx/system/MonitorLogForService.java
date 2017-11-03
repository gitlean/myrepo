package com.xxx.system;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义Pointcuts
 * @author john
 *
 */


@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MonitorLogForService {
	public String module() default "";
	public String operation() default "";
	public String type() default "";
	public boolean fg() default false;

}
