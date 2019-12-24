package com.example.demo.Entity;

import lombok.Data;

import java.lang.annotation.Annotation;
@Getter
@TestAnnotation
@RuntimeAnnotation
public class LombokTest {

    @TestAnnotation
    private long id = 1;

    @TestAnnotation
    public static void main(String[] args) {
        LombokTest test = new LombokTest();
        Annotation[] annotations = LombokTest.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
            //System.out.println(test .getId());
        }
    }

}
