package de.whs.fpr.browser.data.types;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Methods.
 *
 * Represents the methods of a class.
 *
 * @author Frederik Bußmann
 */
public class Methods {
    /**
     * Array of the class methods.
     */
    private final Method[] methods;

    /**
     * Class constructor.
     *
     * @param classData The class to obtain the methods from.
     */
    public Methods(final Class<?> classData) {
        this.methods = classData.getDeclaredMethods();
    }

    /**
     * Converts the types of methods of a class to a string.
     *
     * @return The methods of the class as a string.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Method method : methods) {
            stringBuilder.append(ClassData.INDENTATION);

            if (method.getModifiers() != 0) {
                stringBuilder.append(Modifier.toString(method.getModifiers())).append(" ");
            }

            stringBuilder.append(method.getAnnotatedReturnType()).append(" ");
            stringBuilder.append(method.getName()).append("(");

            AnnotatedType[] parameters = method.getAnnotatedParameterTypes();
            stringBuilder.append(ClassData.AnnotatedTypesToString(parameters));
        }

        return stringBuilder.toString();
    }
}
