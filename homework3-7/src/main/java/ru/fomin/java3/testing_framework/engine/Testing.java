package ru.fomin.java3.testing_framework.engine;

import org.apache.logging.log4j.*;
import ru.fomin.java3.testing_framework.annonetions.AfterSuite;
import ru.fomin.java3.testing_framework.annonetions.BeforeSuite;
import ru.fomin.java3.testing_framework.annonetions.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class Testing {
    private static final Logger LOGGER = LogManager.getLogger(Testing.class);
    private static Map<Integer, LinkedList<Method>> methodTestTreeMap;
    private static final Method[] SPECIAL_METHODS = new Method[2];

    public static void start(String className) {
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class was not found by name");
            throw new RuntimeException("Class was not found by name");
        }
    }

    public static void start(Class clazz) {
        LOGGER.info("Preparing for testing was started");
        methodTestTreeMap = new TreeMap<>(Collections.reverseOrder());
        Annotation annotation;
        Integer priority;
        SPECIAL_METHODS[0] = null;
        SPECIAL_METHODS[1] = null;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if ((annotation = method.getDeclaredAnnotation(Test.class)) != null) {
                priority = ((Test) annotation).priority();
                addListToMap(priority, method);
            } else if (method.getDeclaredAnnotation(BeforeSuite.class) != null) {
                if (SPECIAL_METHODS[0] == null) {
                    SPECIAL_METHODS[0] = method;
                } else {
                    LOGGER.error("Testing class has more annotation 'BeforeSuite' than one");
                    throw new RuntimeException("Testing class has more annotation 'BeforeSuite' than one");
                }
            } else if (method.getDeclaredAnnotation(AfterSuite.class) != null) {
                if (SPECIAL_METHODS[1] == null) {
                    SPECIAL_METHODS[1] = method;
                } else {
                    LOGGER.error("Testing class has more annotation 'AfterSuite' than one");
                    throw new RuntimeException("Testing class has more annotation 'AfterSuite' than one");
                }
            }
        }
        LOGGER.info("Preparing for testing was finished");
        try {
            testing(clazz);
        } catch (InstantiationException e) {
            LOGGER.error(e);
        } catch (IllegalAccessException e) {
            LOGGER.error(e);
        } catch (InvocationTargetException e) {
            LOGGER.error(e);
        } catch (NoSuchMethodException e) {
            LOGGER.error(e);
        }
    }

    private static void testing(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int priority;
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Object[] args = new Object[0];
        Method method;
        LOGGER.info("Running the method by annotation @BeforeSuite");
        if (SPECIAL_METHODS[0] != null) SPECIAL_METHODS[0].invoke(instance, args);
        LOGGER.info("Start testing methods from class " + clazz.getSimpleName());
        for (Map.Entry<Integer, LinkedList<Method>> entry : methodTestTreeMap.entrySet()) {
            priority = entry.getKey();
            Iterator<Method> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                method = iterator.next();
                LOGGER.info("Start testing method " + method.getName() + " by priority " + priority);
                try {
                    method.invoke(instance, args);
                } catch (Exception e) {
                    LOGGER.warn("Testing of " + method.getName() + " was failed");
                    return;
                }
                LOGGER.info("Testing of " + method.getName() + " was passed");
            }
        }
        LOGGER.info("Running the method by annotation @AfterSuite");
        if (SPECIAL_METHODS[1] != null) SPECIAL_METHODS[1].invoke(instance, args);
    }


    private static void addListToMap(Integer priority, Method method) {
        LinkedList<Method> list = methodTestTreeMap.containsKey(priority) ? methodTestTreeMap.get(priority) : new LinkedList<>();
        list.add(method);
        methodTestTreeMap.put(priority, list);
    }
}
