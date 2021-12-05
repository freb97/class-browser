package de.whs.fpr.browser.data.types;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Constructors.
 *
 * Represents the constructors of a class.
 *
 * @author Frederik Bußmann
 */
public class Constructors {
    /**
     * Array of the class constructors.
     */
    private final Constructor<?>[] constructors;

    /**
     * Class constructor.
     *
     * @param classData The class to obtain the constructors from.
     */
    public Constructors(Class<?> classData) {
        this.constructors = classData.getDeclaredConstructors();
    }

    /**
     * Converts the types of constructors of a class to a string.
     *
     * @return The constructors of the class as a string.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Constructor<?> constructor : constructors) {
            stringBuilder.append(ClassData.INDENTATION);

            if (constructor.getModifiers() != 0) {
                stringBuilder.append(Modifier.toString(constructor.getModifiers())).append(" ");
            }

            stringBuilder.append(constructor.getDeclaringClass().getSimpleName()).append("(");

            AnnotatedType[] parameters = constructor.getAnnotatedParameterTypes();
            stringBuilder.append(ClassData.AnnotatedTypesToString(parameters));
        }

        return stringBuilder.toString();
    }
}
