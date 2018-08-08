package com.computers.support.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {

    String ID() default "";

    String priority() default "";

    String desciption() default "";
}
