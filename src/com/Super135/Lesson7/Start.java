package com.Super135.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {
    public static void start(Class classTest){
        List<Method> methodList = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method[] methods = classTest.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)){
                methodList.add(m);
            } else if(m.isAnnotationPresent(BeforeSuite.class)){
                if (beforeMethod == null) {
                    beforeMethod = m;
                } else {
                    throw new RuntimeException("Аннотация @BeforeSuite встречается больше одного раза");
                }
            } else if (m.isAnnotationPresent(AfterSuite.class)){
                if (afterMethod == null) {
                    afterMethod = m;
                } else {
                    throw new RuntimeException("Аннотация @AfterSuite встречается больше одного раза");
                }
            }
        }
        methodList.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(Test.class).level()));

        if (beforeMethod != null) {
            methodList.add(0,beforeMethod);
        }
        if (afterMethod != null) {
            methodList.add(afterMethod);
        }

        for (Method m :methodList) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
