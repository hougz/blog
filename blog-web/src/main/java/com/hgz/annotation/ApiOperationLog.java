package com.hgz.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperationLog {

    String resourceId() default "";
    String operationType();
    String description() default "";

}
