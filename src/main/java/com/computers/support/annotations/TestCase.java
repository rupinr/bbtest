package com.computers.support.annotations;


import com.computers.support.Priority;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {

    String id() default "";

    Priority priority() ;

    String desciption() default "";
}
